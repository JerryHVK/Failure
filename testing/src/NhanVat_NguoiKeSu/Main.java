package NhanVat_NguoiKeSu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    private static final ArrayList<String> linkArraylist = new ArrayList<>();
    public static ArrayList<NhanVatLichSu> nhanVat = new ArrayList<>();
    public static ArrayList<String> listlink = new ArrayList<>();

    public static void main(String[] args) {

        //long startTime = System.currentTimeMillis();

        // TODO: get all the links of characters into "listlink"
        linkArraylist.add("https://nguoikesu.com/nhan-vat?start");
        for (int i = 1; i <= 218; i++) { //218
            String link = "https://nguoikesu.com/nhan-vat?start=" + i * 5;
            linkArraylist.add(link);
        }

        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<?>> futures = new ArrayList<>();
        for (String url : linkArraylist) {
            Future<?> future = executor.submit(genThread_T(url));
            futures.add(future);
        }
        //Await all runnables to be done (blocking)
        for (Future<?> future : futures) {
            try {
                future.get(); // get will block until the future is done
            } catch (InterruptedException | ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        }
        //Check if all runnables are done (non-blocking)
        boolean allDone = true;
        for (Future<?> future : futures) {
            allDone &= future.isDone(); // check if future is done
        }

        //Shutdown executor
        executor.shutdown();

        if (allDone) {
            System.out.println("This is the array of urls: " + listlink);
            System.out.println("Number of urls: " + listlink.size());
            getNhanVatObj();
        }
    }

    private static void getNhanVatObj(){
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<?>> futures = new ArrayList<>();
        for (String url : listlink) {
            Future<?> future = executor.submit(genThread_X(url));
            futures.add(future);
        }

        //Await all runnables to be done (blocking)
        for (Future<?> future : futures) {
            try {
                future.get(); // get will block until the future is done
            } catch (InterruptedException | ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        }

        //Check if all runnables are done (non-blocking)
        boolean allDone = true;
        for (Future<?> future : futures) {
            allDone &= future.isDone(); // check if future is done
        }
        if (allDone) {
            System.out.println(nhanVat);
            writeToJSON(nhanVat);
        }

        //Shutdown executor
        executor.shutdown();
    }
    private static Thread genThread_T(String url) {
        Thread_T t = new Thread_T();
        t.setUrl(url);
        return new Thread(t);
    }

    private static Thread genThread_X(String url) {
        Thread_X t = new Thread_X();
        t.setUrl(url);
        return new Thread(t);
    }

    private static void writeToJSON(ArrayList<NhanVatLichSu> nv) {
        JSONArray jsonArray = new JSONArray();
        for (NhanVatLichSu nhanVat : nv) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("tên nhân vật", nhanVat.getTen());
            jsonObject.put("miêu tả", nhanVat.getMieuTa());
            HashMap<String, String> ttcb = nhanVat.getThongTinCoBan();
            if(ttcb!=null){
                for(String key: ttcb.keySet()) jsonObject.put(key, nhanVat.getThongTinCoBan().get(key));
            }
            for(String key: nhanVat.getThongTin().keySet())
                if(key!=null) jsonObject.put(key, nhanVat.getThongTin().get(key));
            jsonArray.put(jsonObject);
        }

        try {
            FileWriter file = new FileWriter("testing/src/NhanVatLichSu.json");
            file.write(jsonArray.toString(1));
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}