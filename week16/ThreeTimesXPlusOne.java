package week16;

import java.util.ArrayList;

public class ThreeTimesXPlusOne {
    public static void threeTimesXPlusOne(int x) {
        if(x == 1) {
            return;
        }
        if (x % 2 == 0) {
            threeTimesXPlusOne(x/2);
            System.out.println(x / 2);
        } else {
            threeTimesXPlusOne(3 * x + 1);
            System.out.println(3 * x + 1);
        }
    }
    public static void main(String[] args) {
        int x = 100;
        threeTimesXPlusOne(x);
        System.out.println(x);
    }
}
