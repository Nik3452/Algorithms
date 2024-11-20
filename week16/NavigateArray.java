package week16;

public class NavigateArray {
    public static int largestNum(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
    public static int navigateArray(int index, int[] array) {
        if(!(index >= 0 && index < array.length)) {
            return index;
        }
        index = array[index];
        if(largestNum(array) == array.length - 1) {
            System.out.println("Output Is Infinite");
            return 0;
        }
        return navigateArray(index, array);
    }
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {6, 5, 9, 0, 2, 8, 4, 3, 7, 1};
        int num = navigateArray(n,arr);
        System.out.println(num);
    }

}
