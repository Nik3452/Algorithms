package week15;

public class Factorial {
    public static int Factorial(int n) {
        if(n == 0)
            return 1;
        else
            return Factorial(n-1) * n;
    }
    public static void main(String[] args) {
        System.out.println(Factorial(10));
    }
}
