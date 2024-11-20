package week9;
import java.util.*;
public class SequenceInsert {
    private static final int SIZE = 100000;
    private static long start, finish, timeElapsed;

    public static void main(String[] args) {
        // TODO: create a list and add SIZE elements to it
        Vector<Integer> vectorList = new Vector<>(SIZE) {};
        LinkedList<Integer> linkedList = new LinkedList<>() {};
        ArrayList<Integer> arrayList = new ArrayList<>(SIZE) {} ;
        // Use startTimer() and endTimer() to record how long it takes
        startTimer();
        // add elements with insertElements(list)
        insertElements(linkedList);
        endTimer();
        // print out the first few elements of the list to
        // make sure the elements were really added
    }
    private static void startTimer() {

        start = System.currentTimeMillis();
    }
    private static void endTimer() {
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("time (ms): " + timeElapsed);
    }
    private static void insertElements(List<Integer> l) {
        for (int i = 0; i < SIZE; i++) {
            l.add(l.size(),i);
        }
        System.out.println(l.size());
    }
}
