package week15;

public class TowerOfHanoi {
    public static void solveHanoi(int n, int fromPeg, int toPeg) {
        if (n == 1) {
            System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
            return;
        }
        solveHanoi(n - 1, fromPeg, toPeg);
        System.out.println("Move disk " + n + " from peg " + fromPeg + " to peg " + toPeg);
        solveHanoi(n - 1, toPeg, fromPeg);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3;
        solveHanoi(numberOfDisks, 1, 3);
    }
}