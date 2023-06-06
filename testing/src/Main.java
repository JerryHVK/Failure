import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final ArrayList<String> linkArraylist = new ArrayList<>();
    private static final ArrayList<String> namelinkArraylist = new ArrayList<>();
    public static ArrayList<String> listlink = new ArrayList<>();

    private static int notable = 0;

    public static void main(String[] args) throws IOException {

        //long startTime = System.currentTimeMillis();

        // TODO: get all the links of characters into "listlink"
        linkArraylist.add("https://nguoikesu.com/nhan-vat?start");
        for (int i = 1; i <= 218; i++) { //218
            String link = "https://nguoikesu.com/nhan-vat?start=" + i * 5;
            linkArraylist.add(link);
        }
        //Thread.currentThread().setPriority(1);
        //get article's links from parent links

        //int maxThreads = Runtime.getRuntime().availableProcessors(); // Number of available processors
        int maxThreads = 8;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        System.out.println(maxThreads);
        for (String s : linkArraylist) {
            Thread t = genThread(s);
            executor.execute(t);
        }

        //Shutdown executor
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        /*for(int i=0; i<=linkArraylist.size(); i++){
            Document doc = Jsoup.connect(linkArraylist.get(i)).get();
            Elements names = doc.select("h2[itemprop=name]").select("a");
            for(int j=0; j< names.size(); j++){
                String url = names.get(j).attr("href");
                url = "https://nguoikesu.com" + url;
                //System.out.println(names.get(j));
                listlink.add(url);
            }
        }
        int k=0;
        for(int i=0; i<listlink.size(); i++){
            System.out.println(listlink.get(i));
            k++;
        }
        System.out.println("k = " + k);*/

//        for(int i=0; i<listlink.size(); i++){
//            takeData(listlink.get(i));
//        }
//
//        System.out.println(notable);

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(66000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(listlink.size());
        });
        thread.start();
    }

    public static void takeData(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Element table = doc.getElementsByTag("table").first();
        if (table == null) {
            notable++;
            return;
        }
        //System.out.println(table);
    }

    private static Thread genThread(String url) {
        Thread_T t = new Thread_T();
        t.setUrl(url);
        return new Thread(t);
    }

    private static void startThread(String url) throws InterruptedException {
        Thread t = genThread(url);
        t.start();
        //t.join();
    }
}