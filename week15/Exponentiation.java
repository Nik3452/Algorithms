package week15;

public class Exponentiation {
    public static int Exponentiation(int n, int p) {
        if(p == 0)
            return 1;
        else
            return n * Exponentiation(n, p-1);
    }
    public static void main(String[] args) {
        System.out.println(Exponentiation(10, 2));
    }
}
