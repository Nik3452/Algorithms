package week15;

public class TowerOfHanoiPegs {
    public static void solveHanoi(int n, int fromPeg, int toPeg, int[] auxPegs) {
        if (n == 0) {
            return;
        }
        if (auxPegs.length == 1) {
            solveHanoiClassic(n, fromPeg, toPeg, auxPegs[0]);
            return;
        }
        int k = n - (int) Math.round(Math.sqrt(2 * n + 1)) + 1;
        solveHanoi(k, fromPeg, auxPegs[0], getAuxPegs(auxPegs));
        solveHanoiClassic(n - k, fromPeg, toPeg, auxPegs[0]);
        solveHanoi(k, auxPegs[0], toPeg, getAuxPegs(auxPegs));
    }

    private static void solveHanoiClassic(int n, int fromPeg, int toPeg, int auxPeg) {
        if (n == 1) {
            System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
            return;
        }
        solveHanoiClassic(n - 1, fromPeg, auxPeg, toPeg);
        System.out.println("Move disk " + n + " from peg " + fromPeg + " to peg " + toPeg);
        solveHanoiClassic(n - 1, auxPeg, toPeg, fromPeg);
    }

    private static int[] getAuxPegs(int[] auxPegs) {
        int[] newAuxPegs = new int[auxPegs.length - 1];
        System.arraycopy(auxPegs, 1, newAuxPegs, 0, auxPegs.length - 1);
        return newAuxPegs;
    }

    public static void main(String[] args) {
        int numberOfDisks = 4;
        int initialPeg = 1;
        int targetPeg = 3;
        int[] auxiliaryPegs = {2, 4, 5}; // Example with 5 pegs in total
        solveHanoi(numberOfDisks, initialPeg, targetPeg, auxiliaryPegs);
    }
}