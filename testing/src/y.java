import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class y {
    public static void takeData(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        Element table = doc.getElementsByTag("table").first();
        Elements rows = table.getElementsByTag("tr");

        Elements th = rows.select("th").removeAttr("colspan");
        String name = th.get(0).text();

        for (int i = 1; i < th.size(); i++) {
            key.add(th.get(i).text());
            Element o = th.get(i).nextElementSibling();
            value.add(o.text());
        }

        // Create a JSON object
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", name);

        // Add key-value pairs to the JSON object
        for (int i = 0; i < key.size(); i++) {
            jsonObject.addProperty(key.get(i), value.get(i));
        }

        // Convert JSON object to a formatted JSON string
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(jsonObject);

        // Write JSON string to a file
        try (FileWriter fileWriter = new FileWriter("data.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}