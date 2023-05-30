import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) throws IOException {
        String link = "https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam";
        Document doc = Jsoup.connect(link).get();
        Cart Khang = new Cart();

        Elements table = doc.select("table[cellpadding=0][style]").select("tr");


//        Elements table1 = doc.select("table[cellpadding=0][style=\"width:100%; font-size:90%; text-align:center; border:1px solid lavender;\"]").select("tr");
//        Elements tableRows = doc.select("table.wikitable.sortable tr");
        Khang.add(table);
        //System.out.println(Khang.getCount());
        Khang.printlist();
//        Elements table2 = doc.select("table[cellpadding=\"0\"][style=\"width:100%; font-size:90%; text-align:center; border:lavender;\"]").select("tr");
//        Khang.add(table2);
        //Khang.printName();
        Khang.writeToJson();
    }



}
