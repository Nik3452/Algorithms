package week15;

public class SumOfArray {
    public static int sumOfArray(int[] arr, int n) {
        return sumOfArrayHelper(arr, n, 0);
    }
    private static int sumOfArrayHelper(int[]arr, int n, int sum) {
        if(n >= arr.length) {
            return sum;
        }
        return sumOfArrayHelper(arr, n+1, sum + arr[n]);
    }
    public static void main(String[] args) {
        int[] arr = new int[60];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int n = 30;
        System.out.println(sumOfArray(arr,n));
    }
}
