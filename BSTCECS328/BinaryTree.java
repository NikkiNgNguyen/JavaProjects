/*
Nikki Nguyen
CECS 274-05 & CECS 328
Prog 5 - Binary Tree

 */

import java.util.*;

public class BinaryTree {

    //public static Node root;

    //get user option
    static Scanner scan = new Scanner(System.in);
    static Scanner scan2 = new Scanner(System.in);
    public static void main(String[] Args) {

        Node myTree = new Node();
        int n = 2;
        even(n);
        while (true) {
            //display options to modify list
            myTree.printTree();
            myTree.stats();
            switch (menu()) {
                //add word
                case 'a':
                case 'A':
                    System.out.println("Enter a number: ");
                    int newNum = scan2.nextInt();
                    myTree.add(newNum);
                    //myTree.printTree();
                    break;
                //balance tree
                case 'b':
                case 'B':
                    myTree.balance();
                    break;
                //delete item
                case 'd':
                case 'D':
                    myTree.delete();
                    break;
                //find item
                case 'f':
                case 'F':
                    myTree.find();
                    break;
                //find successor
                case 's':
                case 'S':
                    myTree.searchSuccessor();
                    break;

                //initialize tree
                case 'i':
                case 'I':
                    myTree.newTree();
                    for (int i = 1; i <= 31; i++) {
                        myTree.add(rand());
                    }
                    myTree.balance();
                    break;

                //new tree
                case 'n':
                case 'N':
                    myTree.newTree();

                    break;

                //quit
                case 'q':
                case 'Q':
                    System.out.println("");
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

            }
        }

    }

    public static char menu() {

        System.out.println("");
        System.out.println("");
        System.out.println("(A)dd Item   (B)alance Tree  (D)elete Item  (F)ind Item   (S)earch Successor  (I)nitialize Tree   (N)ew Tree  (Q)uit");
        String validchar = "abdfsinq";
        //looks for the first character
        char c = scan.nextLine().toLowerCase().charAt(0);
        //if not 1 or 2, it'll be -1
        while (validchar.indexOf(c) == -1) {
            System.out.println("Invalid Input");
            System.out.println("(A)dd Item   (B)alance Tree  (D)elete Item  (F)ind Item   (S)earch Successor   (I)nitialize Tree   (N)ew Tree  (Q)uit");
            c = scan.nextLine().toLowerCase().charAt(0);
        }

        return c;
    }

    public static int rand() {
        int max = 1000;
        int min = 100;
        Random rando = new Random();
        int randNum = rando.nextInt(max - min + 1) + min;
        return randNum;
    }


public static int even(int n){
    if(n<= 2)
        return n;
    return n + even(n-2);
    }
}

/*
bubble sort     O(n^2)
selection sort  O(n^2)
quick sort      O(n*log(N))
merge sort      O(n*log(n))
heap sort       O(n*log(n))
comb sort
radix sort      O(n)
*/
