package week10;

import java.util.*;



public class Main {
    static int recrusiveCount;

    public static void main(String[] args) {
        int[] arrRandom = randomArray(10);
        int[] arrOrdered = randomArray(10);
        System.out.println(Arrays.toString(arrRandom));

        System.out.println(Arrays.toString(sortArray(arrRandom)));
    }
    // Question 1
    public static int[] orderedArray (int length) {
        // Initialise Array
        int[] arr = new int[length];
        // Loop through array
        for(int i = 0; i < arr.length; i++) {
            // add the elements for the size - 1
            arr[i] = i;
        }
        return arr;
    }
    // Question 2
    public static int[] randomArray(int length) {
        // Declare Array
        int[] arr = new int[length];
        Random random = new Random();
        // Loop through array
        for(int i = 0; i < arr.length; i++) {
            // add the random elements
            arr[i] = random.nextInt(1,2*length);
        }
        return arr;
    }
    // Question 3
    // Answer to Question 3 is the parameters have a C style calling to the array
    // We can also one line to this return badmax(arr, arr.length-1);
    // From int arr[]
    // To int[] arr
    public static int max(int[] arr) {
        System.out.println("Recursive Calls: " + recrusiveCount);
        return badmax(arr, arr.length-1);
    }
    // Question 4
    // Testing Results
    //
    // Random Array Length 10:
    // 279 Calls
    //
    // Random Array Length 20:
    // 73791 Calls
    //
    // Random Array Length 30:
    // 73433119 Calls
    //
    // Ordered Array Length 10:
    // 447 Calls
    //
    // Ordered Array Length 20:
    // 116799 Calls
    //
    // Ordered Array Length 30:
    // 469762047 Calls
    //
    // End result Random array took less calls to return solution
    //
    // Question 5
    //
    // When we add Math.max we decrease the amount of calls because we are going one by one in the array
    // Instead of backtracking constantly which causes unnecessary calls to the method max
    public static int badmax(int[] arr, int lastpos) {
        recrusiveCount++;
        if (lastpos==0) {
            return arr[0];
        } else return Math.max(arr[lastpos], badmax(arr, lastpos - 1));
    }
    // Question 6 Insertion sort Method
    public static int[] sortArray(int[] array) {
        int size = array.length;

        System.out.println("Starting Loop:");
        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
                System.out.println(Arrays.toString(array));
            }

            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }
        System.out.println("End of Loop");
        return array;
    }
    // Question 7
    //
    // At the start of the iteration step of the loop
    // the variable array should contain sorted numbers of all numbers in array.sublist(0,step)
    //
    // Question 8
    //
    // Initialization
    //
    //  At the initial state we are starting with the array [4, 6, 15, 17, 9, 8, 1, 16, 6, 11]
    //
    // Maintenance
    //
    //  During the loop we can see that it is sorting the values like this
    //
    // [4, 6, 15, 17, 17, 8, 1, 16, 6, 11]
    //[4, 6, 15, 15, 17, 8, 1, 16, 6, 11]
    //[4, 6, 9, 15, 17, 17, 1, 16, 6, 11]
    //[4, 6, 9, 15, 15, 17, 1, 16, 6, 11]
    //[4, 6, 9, 9, 15, 17, 1, 16, 6, 11]
    //[4, 6, 8, 9, 15, 17, 17, 16, 6, 11]
    //[4, 6, 8, 9, 15, 15, 17, 16, 6, 11]
    //[4, 6, 8, 9, 9, 15, 17, 16, 6, 11]
    //[4, 6, 8, 8, 9, 15, 17, 16, 6, 11]
    //[4, 6, 6, 8, 9, 15, 17, 16, 6, 11]
    //[4, 4, 6, 8, 9, 15, 17, 16, 6, 11]
    //[1, 4, 6, 8, 9, 15, 17, 17, 6, 11]
    //[1, 4, 6, 8, 9, 15, 16, 17, 17, 11]
    //[1, 4, 6, 8, 9, 15, 16, 16, 17, 11]
    //[1, 4, 6, 8, 9, 15, 15, 16, 17, 11]
    //[1, 4, 6, 8, 9, 9, 15, 16, 17, 11]
    //[1, 4, 6, 8, 8, 9, 15, 16, 17, 11]
    //[1, 4, 6, 6, 8, 9, 15, 16, 17, 17]
    //[1, 4, 6, 6, 8, 9, 15, 16, 16, 17]
    //[1, 4, 6, 6, 8, 9, 15, 15, 16, 17]
    //
    // From this add we can see that it will shift the numbers until all left values equal less than
    // Max value
    //
    // Termination
    //
    // When the loop terminates we get left with this array
    //
    // [1, 4, 6, 6, 8, 9, 11, 15, 16, 17]
    //
    // Which correctly sorted the array
    //
    // Insertion sort will check the before value with the key variable which is
    // A index in the array this will allow us to check if the value is lower or higher
    // Then duplicate that value in the correct place and then delete that value and
    // We keep doing that until the before value is lower causing the sorted array to be in a
    // ASC order
    //
}


