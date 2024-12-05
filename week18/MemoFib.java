package week16;

import java.util.HashMap;

public class MemoFib {
    // Using memoization to speed up fib
    // Instead of going through the entire recrusion tree again
    // We are just remembering that value and storing to a hash map
    // To use later since Hashmap Lookup is O(1) so it's instant
    private static HashMap<Long, Long> memo = new HashMap<>();
    public static long Fibonacci(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        long result = Fibonacci(n - 1) + Fibonacci(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5000));
    }
}