import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Main {
    private static ArrayList<DanhHieu> danhHieuArrayList = new ArrayList<>();
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        addTrangNguyen();
        addBangNhan();
        writeToJson();
        System.out.println(danhHieuArrayList.size());
        System.out.println(count);
    }

    public static void addTrangNguyen() throws IOException {
        String link = "https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_Tr%E1%BA%A1ng_nguy%C3%AAn_Vi%E1%BB%87t_Nam";
        Document doc = Jsoup.connect(link).get();
        Elements rows = doc.select("table.wikitable.sortable").select("tbody").select("tr");
        for(int i=0; i < rows.size(); i++){
            Element row = rows.get(i);
            Elements columns = row.select("td");
            if(columns.size() < 7) continue;
            if(columns.get(1).text().contains("Nguyễn Giản Thanh")){
                DanhHieu danhHieu1 = new DanhHieu(
                        "Nguyễn Giản Thanh",
                        columns.get(2).text(),
                        columns.get(3).text(),
                        columns.get(4).text(),
                        columns.get(5).text(),
                        "Trạng Me");
                danhHieu1.setDanh_hieu("Trạng nguyên");
                danhHieuArrayList.add(danhHieu1);
                count++;

                DanhHieu danhHieu2 = new DanhHieu(
                        "Hứa Tam Tỉnh",
                        columns.get(2).text(),
                        columns.get(3).text(),
                        columns.get(4).text(),
                        columns.get(5).text(),
                        "Trạng Ngọt");
                danhHieu2.setDanh_hieu("Trạng nguyên");
                danhHieuArrayList.add(danhHieu2);
                count++;
                continue;
            }
            DanhHieu danhHieu = new DanhHieu(
                    columns.get(1).text(),
                    columns.get(2).text(),
                    columns.get(3).text(),
                    columns.get(4).text(),
                    columns.get(5).text(),
                    columns.get(6).text());
            danhHieu.setDanh_hieu("Trạng nguyên");
            danhHieuArrayList.add(danhHieu);
            count++;
        }
    }

    public static void addBangNhan() throws IOException {
        String link = "https://vi.wikipedia.org/wiki/B%E1%BA%A3ng_nh%C3%A3n";
        Document doc = Jsoup.connect(link).get();
        Elements rows = doc.select("table.wikitable.sortable").select("tbody").select("tr");
        for(int i=0; i < rows.size(); i++){
            Element row = rows.get(i);
            Elements columns = row.select("td");
            if(columns.size() < 6) continue;
            DanhHieu danhHieu = new DanhHieu(
                    columns.get(0).text(),
                    columns.get(1).text(),
                    columns.get(2).text(),
                    columns.get(3).text(),
                    columns.get(4).text(),
                    columns.get(5).text());
            danhHieu.setDanh_hieu("Bảng nhãn");
            danhHieuArrayList.add(danhHieu);
            count++;
        }
    }



    public static void add(Elements rows){
        for(int i=0; i < rows.size(); i++){
            Element row = rows.get(i);
            Elements columns = row.select("td");
            if(columns.size() < 7) continue;
            DanhHieu danhHieu = new DanhHieu(
                    columns.get(1).text(),
                    columns.get(2).text(),
                    columns.get(3).text(),
                    columns.get(4).text(),
                    columns.get(5).text(),
                    columns.get(6).text());
            danhHieu.setDanh_hieu("Trạng nguyên");
            danhHieuArrayList.add(danhHieu);
        }
    }

    public static void printlist(){
        int i=0;
        for(DanhHieu p : danhHieuArrayList){
            i++;
            System.out.println("Người thứ " + i);
            System.out.println("Tên: " + p.getTen());
            System.out.println("Năm sinh: " + p.getNam_sinh());
            System.out.println("Năm mất: " + p.getNam_mat());
            System.out.println("Quê quán: " + p.getQue_quan());
            System.out.println("Năm đỗ: " + p.getNam_do());
            System.out.println("Danh hiệu: " + p.getDanh_hieu());
            System.out.println("Đời vua: " + p.getDoi_vua());
            System.out.println("Ghi chú: " + p.getGhi_chu());
            System.out.println("================================");
        }
    }

    public static void writeToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(danhHieuArrayList);

        try {
            FileWriter file = new FileWriter("TrangNguyen&BangNhan.json");
            file.write(json);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}