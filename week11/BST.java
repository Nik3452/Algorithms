package week11;
/**
 * Ordinary binary search trees, with int keys
 *
 * @version 3
 * @author akj22 (v2,3), smk (v1)
 * Changes: main method added, edited height of empty tree, removed redblack trees
 *
 */
import java.util.Random;
public class BST
{
    // instance variables - replace the example below with your own
    private int key;
    private BST left,right;

    //fixed BST that is the dedicated empty tree, by convention
    public static final BST empty=new BST();

    //global random number generator
    private static final Random rg=new Random();

    //private constructor, only used for empty tree, once
    private BST() {}

    public static BST empty() { return empty; }
    public boolean isEmpty() { return this==empty; }

    /**
     * Constructor for singleton BST
     * Use this constructor
     */
    public BST(int k)
    {
        key=k;
        left=right=empty;
    }

    public boolean search(int k) {
        if (isEmpty()) return false;
        if (k==key) return true;
        if (k<key) return left.search(k);
        else return right.search(k);
    }

    public int size() {
        if (isEmpty()) return 0;
        return left.size()+right.size()+1;
    }

    //add k to BST if it is not already there
    public BST insert(int k) {
        if (isEmpty()) return new BST(k);
        if (k<key) {
            left=left.insert(k);
        } else if (k>key) {
            right=right.insert(k);
        }
        return this;
    }

    //create a random tree by inserting n distinct random numbers (between 1 and 4n)
    //into an empty tree
    public static BST randomTree(int n) {
        BST res=empty;
        for (int i=0; i<n; i++) {
            int k;
            do {//loop ensures number is fresh
                k=rg.nextInt(4*n)+1;
            } while (res.search(k));
            res=res.insert(k);
        }
        return res;
    }

    public int height() {
        if (isEmpty()) return -1;
        //height of a tree is 1+height of the taller subtree
        //base case: height of a leaf is 0
        //empty tree has height -1
        return 1 + Math.max(left.height(), right.height());
    }

    public boolean isAVL() {
        // If the tree is empty, return true
        if (isEmpty())  {
            return true;
        }
        // If the difference between the left and right subtree is greater than 1, return false
        if (Math.abs(left.height()-right.height())>1) {
            return false;
        }
        // If the left and right subtree are AVL, return true
        return left.isAVL() && right.isAVL();
    }


    public static void randomReport(int size) {
        //try 100 random trees of size
        //what percentage is AVL? what percentage can be expressed as a RB tree
        int avl=0,rb=0;
        // Looping through the size
        for (int i=0; i<size; i++) {
            BST t = randomTree(size);
            // Checking if the tree is AVL
            if (t.isAVL()) {
                avl++;
            }
            //height of a red-black tree is at most 2log2(n+1)
            //where n is the number of nodes
            //Checking if the tree is a Red-Black Tree
            if (t.height() <= 2*Math.log(size+1)/Math.log(2)) {
                rb++;
            }
        }
        System.out.println("Task 3: Random Report");
        System.out.println("Size: "+ size +" AVL: "+ avl +" RB: "+ rb);
    }

    public String toString() {
        return toString("");
    }
    private String toString(String lead) {
        if (isEmpty()) return lead + "E\n";
        return lead + key + "\n" + left.toString(lead+"    ") + right.toString(lead+"    ");
    }

    public static void main(String[] args)  {
        BST binSearchTree = new BST(5);  // set up a new instance of BST with a root node key =5
        System.out.println(binSearchTree.toString()); // use the toString method to look at the contents of the tree
        System.out.println("Task 1: Height = "+binSearchTree.height());  // we expect this height to be 0
        System.out.println("Task 2: isAVL() = "+binSearchTree.isAVL());  // we expect isAVL = true

        binSearchTree.insert(6); // example of how to call the insert method to add a new node to our binSearchTree, with key = 6
        System.out.println(binSearchTree.toString()); // use the toString method to look at the contents of the tree

        System.out.println("Task 1: Height = "+binSearchTree.height()); // we expect this height to be 1
        System.out.println("Task 2: isAVL() = "+binSearchTree.isAVL()); // we expect isAVL = true

        binSearchTree.insert(7); // example of how to call the insert method to add a new node to our binSearchTree, with key = 7
        System.out.println(binSearchTree.toString()); // use the toString method to look at the contents of the tree

        System.out.println("Task 1: Height = "+binSearchTree.height()); // we expect this height to be 2
        System.out.println("Task 2: isAVL() = "+binSearchTree.isAVL()); // we expect isAVL = false

        binSearchTree.insert(4); // example of how to call the insert method to add a new node to our binSearchTree, with key = 4
        System.out.println(binSearchTree.toString()); // use the toString method to look at the contents of the tree

        System.out.println("Task 1: Height = "+binSearchTree.height()); // we expect this height to be 2
        System.out.println("Task 2: isAVL() = "+binSearchTree.isAVL()); // we expect isAVL = true

        randomReport(100); // we expect this to print out the results of the randomReport method
    }
}