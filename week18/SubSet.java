package week18;

import java.util.HashSet;

public class SubSet {
    public static boolean subSet(HashSet<Integer> integers, int k) {
        if(k < 0) return false;
        if(k== 0) return true;
        if(integers.isEmpty()) return false;
        for(Integer integer: new HashSet<>(integers)) {
            integers.remove(integer);
            if(subSet(integers,k-integer)) {
                return true;
            }
            integers.add(integer);
        }
        return false;
    }
    public static void main(String[] args) {
        HashSet<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(5);
        integers.add(6);
        integers.add(11);
        integers.add(15);
        integers.add(2);
        boolean result = subSet(integers,30);
        System.out.println(result);
    }
}
