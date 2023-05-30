
//still need to consider

public class TryString {
    public static void main(String[] args){
        String str = "Thái Đức (1778-1788)[110]";
        str = clear(str);
        System.out.println(str);

    }

    public static String clear(String str){

        while(true){
            int index1 = str.indexOf("(");
            if(index1 < 0) break;
            int index2 = str.indexOf(")");
            String s = "";
            for(int i=index1; i<=index2; i++){
                s = s + str.charAt(i);
            }
            str = str.replaceAll(s, "");
        }
        while(true){
            int index1 = str.indexOf("[");
            if(index1 < 0) break;
            int index2 = str.indexOf("]");
            String s = "";
            for(int i=index1; i<=index2; i++){
                s = s + str.charAt(i);
            }
            str = str.replaceAll(s, "");
        }
        return str;
    }
}
