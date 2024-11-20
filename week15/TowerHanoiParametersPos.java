package week15;

public class TowerHanoiParametersPos {
    public static void solveHanoi(int n, int fromPeg, int toPeg, int auxPeg) {
        if (n == 1) {
            System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
            return;
        }
        solveHanoi(n - 1, fromPeg, auxPeg, toPeg);
        System.out.println("Move disk " + n + " from peg " + fromPeg + " to peg " + toPeg);
        solveHanoi(n - 1, auxPeg, toPeg, fromPeg);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3;
        int initialPeg = 1;
        int targetPeg = 3;
        int auxiliaryPeg = 2;
        solveHanoi(numberOfDisks, initialPeg, targetPeg, auxiliaryPeg);
    }
}