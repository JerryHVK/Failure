package NhanVat_NguoiKeSu;

import java.util.HashMap;

public class NhanVatLichSu {
    private String ten;
    private HashMap<String, String> thongTinCoBan;
    private String mieuTa;
    private HashMap<String, String> thongTin;

    public NhanVatLichSu() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public HashMap<String, String> getThongTinCoBan() {
        return thongTinCoBan;
    }

    public void setThongTinCoBan(HashMap<String, String> thongTinCoBan) {
        this.thongTinCoBan = thongTinCoBan;
    }

    public String getMieuTa() {
        return mieuTa;
    }

    public void setMieuTa(String mieuTa) {
        this.mieuTa = mieuTa;
    }

    public HashMap<String, String> getThongTin() {
        return thongTin;
    }

    public void setThongTin(HashMap<String, String> thongTin) {
        this.thongTin = thongTin;
    }

    public NhanVatLichSu(String ten, HashMap<String, String> thongTinCoBan, String mieuTa, HashMap<String, String> thongTin) {
        this.ten = ten;
        this.thongTinCoBan = thongTinCoBan;
        this.mieuTa = mieuTa;
        this.thongTin = thongTin;
    }
}
