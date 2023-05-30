public class TrangNguyen {
    private String ten;
    private String nam_sinh;
    private String nam_mat;
    private String que_quan;
    private String nam_do;
    private String doi_vua;
    private String ghichu = "";

    public TrangNguyen(String name, String namsinhnammat, String que, String namdotrangnguyen, String doivua, String ghichu){
        this.ten = name;
        this.que_quan = que;
        this.nam_do = namdotrangnguyen;
        this.doi_vua = doivua;
        if(ghichu.isBlank()) this.ghichu = "không có";
        else this.ghichu = ghichu;
        if(namsinhnammat.isBlank()) {
            this.nam_sinh = "không rõ";
            this.nam_mat = "không rõ";
        }
        else{
            String[] s = namsinhnammat.split("-", -1);
            if(s[0].contains("?")) this.nam_sinh = "không rõ";
            else this.nam_sinh = s[0];

            if(s[1].contains("?")) this.nam_mat = "không rõ";
            else this.nam_mat = s[1];
        }
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

    public String getDoi_vua() {
        return doi_vua;
    }

    public String getGhichu() {
        return ghichu;
    }
}
