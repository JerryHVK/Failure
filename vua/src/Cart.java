import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cart {
    ArrayList<Vua> vuaArrayList = new ArrayList<>();
    public void add(Elements tableRows) {

        for (int i = 1; i < tableRows.size(); i++) {
            Element row = tableRows.get(i);
            Elements columns = row.select("td");


            if (columns.size() <= 8) {
                //System.out.println(row.text());
                continue;
            }


//            if (name.contains("An Dương Vương")) {
////                Vua vua1 = new Vua(columns.get(0).select("img").attr("src"),
////                        "An Dương Vương",
////                        columns.get(2).text(),
////                        columns.get(3).text(),
////                        columns.get(4).text(),
////                        columns.get(5).text(),
////                        columns.get(6).text(),
////                        "257 TCN", "208 TCN");
////                vuaArrayList.add(vua1);
//                continue;
//            }

            if (columns.get(1).text().contains("Trần Cảo")) {
                Vua vua2 = new Vua(columns.get(0).select("img").attr("src"),
                        "Trần Cảo",
                        columns.get(2).text(),
                        columns.get(3).text(),
                        columns.get(4).text(),
                        columns.get(5).text(),
                        "không rõ",
                        "1426", "1428");
                vuaArrayList.add(vua2);
                continue;
            }

            if (columns.size() != 10) {
                //System.out.println(row.text());
                continue;
            }

            String name = columns.get(1).text();


            String img = columns.get(0).select("img").attr("src");
            //String name = columns.get(1).text();
            String mieuhieu = columns.get(2).text();
            String thuyhieu = columns.get(3).text();
            String nienhieu = columns.get(4).text();
            String tenhuy = columns.get(5).text();
            String thethu = columns.get(6).text();
            String start = columns.get(7).text();
            //String middle = columns.get(8).text();
            String end = columns.get(9).text();

            Vua vua = new Vua(img, name, mieuhieu, thuyhieu, nienhieu, tenhuy, thethu, start, end);
            vuaArrayList.add(vua);
        }

        Vua vua1 = new Vua("",
                "An Dương Vương",
                "không có",
                "An Dương Vương",
                "không có",
                "Thục Phán",
                "Hậu duệ Khai Minh thị nước Thục thời Xuân Thu Chiến Quốc",
                "257 TCN", "208 TCN");
        vuaArrayList.add(vua1);
    }



//        for (int i = 1; i < tableRows.size(); i++) {
//            Element row = tableRows.get(i);
//            Elements columns = row.select("td");
//            if (columns.size() >= 10){
//                //System.out.println(row.text());
//                continue;
//            }
//
//            if(columns.get(1).text().contains("An Dương Vương")){
//                Vua vua1 = new Vua(columns.get(0).select("img").attr("src"),
//                        "An Dương Vương",
//                        columns.get(2).text(),
//                        columns.get(3).text(),
//                        columns.get(4).text(),
//                        columns.get(5).text(),
//                        columns.get(6).text(),
//                        "257 TCN", "208 TCN");
//            }
//
//            String img = columns.get(0).select("img").attr("src");
//            String name = columns.get(1).text();
//            String mieuhieu = columns.get(2).text();
//            String thuyhieu = columns.get(3).text();
//            String nienhieu = columns.get(4).text();
//            String tenhuy = columns.get(5).text();
//            String thethu = columns.get(6).text();
//            String start = columns.get(7).text();
//            //String middle = columns.get(8).text();
//            String end = columns.get(9).text();
//
//            Vua vua = new Vua(img, name, mieuhieu, thuyhieu, nienhieu, tenhuy, thethu, start, end);
//            vuaArrayList.add(vua);
//        }
//    }


    public void printlist(){
        int i=0;
        for (Vua vua : vuaArrayList) {
            i++;
            System.out.println("Người thứ " + i);
            System.out.println("Ảnh: " + vua.getImg());
            System.out.println("Tên: " + vua.getTen());
            System.out.println("Miếu hiệu: " + vua.getMieu_hieu());
            // Print other fields as needed
            System.out.println("Thụy hiệu: " + vua.getThuy_hieu());
            System.out.println("Niên hiệu: " + vua.getNien_hieu());
            System.out.println("Tên húy: " + vua.getTen_huy());
            System.out.println("Thế thứ: " + vua.getThe_thu());
            System.out.println("Năm lên ngôi: " + vua.getNam_bat_dau_tri_vi());
            //System.out.println("Middle: " + vua.getMiddle());
            System.out.println("Năm thoái vị: " + vua.getNam_ket_thuc_tri_vi());
            System.out.println();
        }
    }

    public void printName(){
        int i=0;
        for (Vua vua : vuaArrayList) {
            i++;
            System.out.println(i + ". " + vua.getTen());
            System.out.println();
        }
    }

    public void printNameforexception(){

    }

    public void writeToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(vuaArrayList);

        try {
            FileWriter file = new FileWriter("Vua.json");
            file.write(json);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
