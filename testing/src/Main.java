import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static ArrayList<String> linkArraylist = new ArrayList<>();
    private static ArrayList<String> namelinkArraylist = new ArrayList<>();
    private static ArrayList<String> listlink = new ArrayList<>();

    private static int notable = 0;
    public static void main(String[] args) throws IOException {

        // TODO: get all the links of characters into "listlink"
        linkArraylist.add("https://nguoikesu.com/nhan-vat?start");
        for(int i=1; i<=5; i++){ //218
            String link = "https://nguoikesu.com/nhan-vat?start=" + String.valueOf(i*5);
            linkArraylist.add(link);
        }

        for(int i=0; i<=5; i++){
            Document doc = Jsoup.connect(linkArraylist.get(i)).get();
            Elements names = doc.select("h2[itemprop=name]").select("a");
            for(int j=0; j< names.size(); j++){
                String url = names.get(j).attr("href");
                url = "https://nguoikesu.com" + url;
                //System.out.println(names.get(j));
                listlink.add(url);
            }
        }
//        int k=0;
//        for(int i=0; i<listlink.size(); i++){
//            System.out.println(listlink.get(i));
//            k++;
//        }
//        System.out.println("k = " + k);

        for(int i=0; i<listlink.size(); i++){
            takeData(listlink.get(i));
        }

        System.out.println(notable);



    }

    public static void takeData(String url) throws IOException {
        Document doc  = Jsoup.connect(url).get();
        Element table = doc.getElementsByTag("table").first();
        if(table == null){
            notable++;
            return;
        }
        //System.out.println(table);
    }
}