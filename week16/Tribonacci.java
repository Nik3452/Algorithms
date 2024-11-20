package week16;

import java.util.HashMap;

public class Tribonacci {
    // Using memoization to speed up tribonacci
    // Instead of going through the entire recursion tree again
    // We are just remembering that value and storing to a hash map
    // To use later since HashMap Lookup is O(1) so it's instant
    private static HashMap<Long, Long> memo = new HashMap<>();

    public static long Tribonacci(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        long result = Tribonacci(n - 1) + Tribonacci(n - 2) + Tribonacci(n - 3);

        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(Tribonacci(6));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime); // in nanoseconds
        double durationInSeconds = duration / 1_000_000_000.0; // convert to seconds
        System.out.println("Execution time: " + durationInSeconds + " seconds");
    }
}