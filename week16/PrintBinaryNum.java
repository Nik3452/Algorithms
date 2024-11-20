package week16;

public class PrintBinaryNum {
    public static void printBinaryNum(int n) {
        printBinaryNumHelper(n, "");
    }
    private static void printBinaryNumHelper(int n, String prefix) {
        if(n == 0) {
            System.out.println(prefix);
        } else {
            printBinaryNumHelper(n-1, prefix + "0");
            printBinaryNumHelper(n-1, prefix + "1");
        }
    }
    public static void main(String[] args) {
        int n = 4;
        printBinaryNum(n);
    }
}
