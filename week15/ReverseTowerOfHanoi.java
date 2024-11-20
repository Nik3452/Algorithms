package week15;
public class ReverseTowerOfHanoi {

    // Recursive function to solve the reverse Tower of Hanoi
    public static void reverseHanoi(int n, int fromRod, int toRod, int auxRod) {
        if (n == 0) {
            return;
        }

        // Move n-1 discs from 'fromRod' to 'auxRod' using 'toRod'
        reverseHanoi(n - 1, fromRod, auxRod, toRod);

        // Move the current largest disc (bottom-most) from 'fromRod' to 'toRod'
        System.out.println("Move disc " + (4 - n) + " from peg " + fromRod + " to peg " + toRod);

        // Move n-1 discs from 'auxRod' to 'toRod' using 'fromRod'
        reverseHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        int n = 3; // Number of discs
        System.out.println("Reverse Tower of Hanoi with 1 at the bottom and 3 at the top:");
        reverseHanoi(n, 1, 3, 2); // A is source, C is destination, B is auxiliary
    }
}
