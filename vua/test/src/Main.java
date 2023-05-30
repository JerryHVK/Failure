public class Main {
    public static void main(String[] args) {
        String year = "123 tcn";
        if(year.contains("TCN")) System.out.println("contains() không phân biệt hoa thường");
        else System.out.println("contains() phân biệt hoa thường");
    }
}