import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static ArrayList<TrangNguyen> tnArraylist = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String link = "https://vi.wikipedia.org/wiki/B%E1%BA%A3ng_nh%C3%A3n";
        Document doc = Jsoup.connect(link).get();
        Elements rows = doc.select("table.wikitable.sortable").select("tbody").select("tr");
        add(rows);
        printlist();

    }

    public static void add(Elements rows){
        for(int i=0; i < rows.size(); i++){
            Element row = rows.get(i);
            Elements columns = row.select("td");
            if(columns.size() < 6) continue;
            TrangNguyen tn = new TrangNguyen(
                    columns.get(0).text(),
                    columns.get(1).text(),
                    columns.get(2).text(),
                    columns.get(3).text(),
                    columns.get(4).text(),
                    columns.get(5).text());
            tnArraylist.add(tn);
        }
    }

    public static void printlist(){
        int i=0;
        for(TrangNguyen p : tnArraylist){
            i++;
            System.out.println("Trạng nguyên thứ " + i);
            System.out.println("Tên: " + p.getTen());
            System.out.println("Năm sinh: " + p.getNam_sinh());
            System.out.println("Năm mất: " + p.getNam_mat());
            System.out.println("Quê quán: " + p.getQue_quan());
            System.out.println("Năm đỗ trạng nguyên: " + p.getNam_do());
            System.out.println("Đời vua: " + p.getDoi_vua());
            System.out.println("Ghi chú: " + p.getGhichu());
            System.out.println("================================");
        }
    }

}