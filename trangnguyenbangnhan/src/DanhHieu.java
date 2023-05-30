public class DanhHieu {
    private String ten;
    private String nam_sinh;
    private String nam_mat;
    private String que_quan;
    private String nam_do;
    private String danh_hieu;
    private String doi_vua;
    private String ghi_chu = "";


    public void setDanh_hieu(String danh_hieu){
        this.danh_hieu = danh_hieu;
    }

    public DanhHieu(String ten, String sinhmat, String que_quan, String nam_do, String doi_vua, String ghi_chu) {
        this.ten = ten;

        if(sinhmat.isBlank()) {
            this.nam_sinh = "không rõ";
            this.nam_mat = "không rõ";
        }
        else{
            String[] s = sinhmat.split("-", -1);
            if(s[0].contains("?")) this.nam_sinh = "không rõ";
            else this.nam_sinh = s[0];

            if(s[1].contains("?")) this.nam_mat = "không rõ";
            else this.nam_mat = s[1];
        }

        this.que_quan = que_quan;
        this.nam_do = nam_do;
        this.doi_vua = doi_vua;
        this.ghi_chu = clearGhichu(ghi_chu);
    }

    public String clearGhichu(String ghichu){
        if(ghichu.isBlank()) ghichu = "không có";
        else{
            if(ghichu.contains("[")){
                StringBuilder s = new StringBuilder(ghichu);
                int index1 = s.indexOf("[");
                int index2 = s.indexOf("]");
                s.delete(index1, index2+1);
                ghichu = s.toString();
            }
        }
        return ghichu;
    }

    public String getTen() {
        return ten;
    }

    public String getNam_sinh() {
        return nam_sinh;
    }

    public String getNam_mat() {
        return nam_mat;
    }

    public String getQue_quan() {
        return que_quan;
    }

    public String getNam_do() {
        return nam_do;
    }

    public String getDanh_hieu() {
        return danh_hieu;
    }

    public String getDoi_vua() {
        return doi_vua;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }
}
