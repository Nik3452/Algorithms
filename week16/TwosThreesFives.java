package week16;

public class TwosThreesFives {
    public static int countFactors(int n, int i) {
        if (n == 1) {
            return 0;
        }
        if (n % i == 0) {
            return 1 + countFactors(n / i, i);
        }
        return 0;
    }

    public static int productOfFactors(int n) {
        int count2s = countFactors(n, 2);
        int count3s = countFactors(n, 3);
        int count5s = countFactors(n, 5);
        return (int) (Math.pow(2, count2s) * Math.pow(3, count3s) * Math.pow(5, count5s));
    }

    public static void main(String[] args) {
        int n = 46200;
        int product = productOfFactors(n);
        System.out.println("Product of 2, 3, and 5 factors of " + n + " is: " + product);
    }
}