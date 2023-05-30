public class TryStringChatGPT {
    public static void main(String[] args) {
        String str = "Thái Đức (1778-1788)[110]";
        str = clear(str);
        System.out.println(str);
    }

    public static String clear(String str) {
        boolean modified = true;

        while (modified) {
            int index1 = str.indexOf("(");
            int index2 = str.indexOf(")");

            if (index1 >= 0 && index2 >= 0) {
                String s = str.substring(index1, index2 + 1);
                str = str.replace(s, "");
            } else {
                modified = false;
            }
        }

        modified = true;

        while (modified) {
            int index1 = str.indexOf("[");
            int index2 = str.indexOf("]");

            if (index1 >= 0 && index2 >= 0) {
                String s = str.substring(index1, index2 + 1);
                str = str.replace(s, "");
            } else {
                modified = false;
            }
        }

        return str;
    }
}
