public class StringClearYear {

    private String nam_bat_dau_tri_vi;
    private String nam_ket_thuc_tri_vi;

    public StringClearYear(String nam_bat_dau_tri_vi, String nam_ket_thuc_tri_vi){
        clearYear(nam_bat_dau_tri_vi, nam_ket_thuc_tri_vi);
    }

    public void clearYear(String nam_bat_dau_tri_vi, String nam_ket_thuc_tri_vi){
        nam_bat_dau_tri_vi = subClearYear(nam_bat_dau_tri_vi);
        nam_ket_thuc_tri_vi = subClearYear(nam_ket_thuc_tri_vi);

        boolean n1 = nam_bat_dau_tri_vi.contains("không rõ");
        boolean n2 = nam_bat_dau_tri_vi.contains("không rõ");

        if(n1 && n2){
            this.nam_bat_dau_tri_vi = "không rõ";
            this.nam_ket_thuc_tri_vi = "không rõ";
            return;
        }

        if(n1 && !n2){

        }
    }

    public String subClearYear(String year){
        char[] chars = year.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                return year;
            }
        }
        return "không rõ";
    }

    public int tcnClearYear(String year){
        if(year.contains("TCN")){
            String s = "-";
            char[] chars = year.toCharArray();
            for(char c : chars){
                if(Character.isDigit(c)){
                    s += c;
                }
            }
            return Integer.parseInt(s);
        }
        else
    }
}
