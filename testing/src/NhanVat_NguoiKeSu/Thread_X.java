package NhanVat_NguoiKeSu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

public class Thread_X implements Runnable{

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        getDuLieuNhanVatObj(url);
    }

    private void getDuLieuNhanVatObj(String url){
        Document doc;
        try {
            doc = Jsoup.connect(url)
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Create a nhanVatLichSu object
        NhanVatLichSu nv = new NhanVatLichSu();

        Element content = doc.getElementsByClass("com-content-article__body").first();
        Element infoBox = content != null ? content.getElementsByClass("infobox").first() : null;

        String ten = doc.getElementsByAttributeValue("itemprop", "headline").text();
        nv.setTen(ten);
        //Handle infobox info
        if (infoBox != null) {
            HashMap<String, String> ttcb = new HashMap<>();
            Element tbody = infoBox.select("tbody").first();
            Elements children;
            if (tbody != null) {
                children = tbody.children();
                for (Element child : children) {
                    if (child.childrenSize() > 1) {
                        String key = child.child(0).text();
                        String value = child.child(1).text();
                        ttcb.put(key, value);
                        //System.out.println(key);
                    }
                }
                nv.setThongTinCoBan(ttcb);
            }
        }else nv.setThongTinCoBan(null);
        //System.out.println(infoBox);

        //Get main info
        HashMap<String, String> thongTin = new HashMap<>();
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (!content.child(i).is("h2") && !content.child(i).is("p")) i++;
        if (content.childrenSize() > 1) {
            while (!content.child(i).is("h2") && content.child(i).is("p")) {
                builder.append(content.child(i).text());
                i++;
            }
            //i++;
            nv.setMieuTa(builder.toString());
            //Lay thong tin dac diem
            String key = null;
            for (; i < content.childrenSize(); i++) {
                StringBuilder builder1 = new StringBuilder();
                if (content.child(i).is("h2")) {
                    key = content.child(i).text();
                    //System.out.println(key);
                } else {
                    while (i < content.childrenSize() && !content.child(i).is("h2")) {
                        builder1.append(content.child(i).text());
                        i++;
                    }
                    if (i != content.childrenSize()) i--;
                }
                thongTin.put(key, builder1.toString());
            }
        }
        nv.setThongTin(thongTin);
        Main.nhanVat.add(nv);
        //System.out.println(nv.getTen());
    }
}
