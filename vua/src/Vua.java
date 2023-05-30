public class Vua {
    private String img;
    private String ten;

    private String mieu_hieu;
    private String thuy_hieu;
    private String nien_hieu;
    private String ten_huy;
    private String the_thu;
    private String nam_bat_dau_tri_vi;
    //private String middle;
    private String nam_ket_thuc_tri_vi;

    private String nam_sinh;
    private String nam_mat;

//    public Vua(String img, String name, String mieu_hieu, String thuyhieu, String nienhieu, String tenhuy, String thethu, String start, String middle, String end) {
//        img =
//                this.img = img;
//        this.ten = clear(name);
//        this.mieu_hieu = mieu_hieu;
//        this.thuy_hieu = thuyhieu;
//        this.nien_hieu = nienhieu;
//        this.ten_huy = tenhuy;
//        this.the_thu = thethu;
//        this.nam_bat_dau_tri_vi = start;
//        this.middle = middle;
//        this.nam_ket_thuc_tri_vi = end;
//    }

    public Vua(String img, String name, String mieu_hieu, String thuyhieu, String nienhieu, String tenhuy, String thethu, String start, String end) {

        this.img = clearImg(img);
        this.ten = clear(name);
        this.mieu_hieu = clear(mieu_hieu);
        this.thuy_hieu = clear(thuyhieu);
        this.nien_hieu = clear(nienhieu);
        this.ten_huy = clear(tenhuy);
        this.the_thu = clear(thethu);
        this.nam_bat_dau_tri_vi = clear(start);
        //this.middle = clear(middle);
        this.nam_ket_thuc_tri_vi = clear(end);
    }

    public String clearImg(String img){
        if(img.equalsIgnoreCase("")) return null;
        return img;
    }

    public  String clear(String str){

        boolean modified = true;
        while(modified) {
            int index1 = str.indexOf("(");
            int index2 = str.indexOf(")");
            if (index1 >= 0 && index2 >= 0) {
                String s = str.substring(index1, index2 + 1);
                str = str.replace(s, "");
            }
            else modified = false;
        }

        modified = true;
        while(modified) {
            int index1 = str.indexOf("[");
            int index2 = str.indexOf("]");
            if (index1 >= 0 && index2 >= 0) {
                String s = str.substring(index1, index2 + 1);
                str = str.replace(s, "");
            }
            else modified = false;
        }

        return str;
    }

//    public String clearName(String name){
//        int index = name.indexOf("[");
//        if(index < 0) return name;
//        else return name.substring(0, index);
//    }

//    public String clear(String str){
//        while(1){
//            int
//        }
//    }

//    public void clearImg(String img){
//
//    }
//    public void clearImg(String img){
//
//    }
//    public void clearImg(String img){
//
//    }
//    public void clearImg(String img){
//
//    }

    public String getTen() {
        return ten;
    }

    public String getMieu_hieu() {
        return mieu_hieu;
    }

    public String getImg() {
        return img;
    }

    public String getThuy_hieu() {
        return thuy_hieu;
    }

    public String getNien_hieu() {
        return nien_hieu;
    }

    public String getTen_huy() {
        return ten_huy;
    }

    public String getThe_thu() {
        return the_thu;
    }

    public String getNam_bat_dau_tri_vi() {
        return nam_bat_dau_tri_vi;
    }

//    public String getMiddle() {
//        return middle;
//    }

    public String getNam_ket_thuc_tri_vi() {
        return nam_ket_thuc_tri_vi;
    }
}
