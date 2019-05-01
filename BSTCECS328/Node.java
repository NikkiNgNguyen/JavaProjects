import java.util.Scanner;

public class Node {

    static Scanner scan2 = new Scanner(System.in);
    public int value;
    public Node leftChild;
    public Node rightChild;
    public Node parent;
    static Node temp = new Node();
    static Node myTree;
    static int array[];
    static Node pivot;

    public Node(int x) {
        value = x;
        leftChild = null;
        rightChild = null;
        parent = null;
    }

    private Node root;
    private int nItems;
    private int treeIndex;
    private String[] aTree = new String[32];

    public Node() {
        root = null;
        for (int i = 1; i <= 31; i++) {
            aTree[i] = " . ";
        }

    }

    public void add(int x) {

        Node temp = new Node(x);
        if (root == null) {
            root = temp;
        } else {
            insertInOrder(root, temp);
        }
        nItems++;
    }

    public void insertInOrder(Node P, Node newN) {

        if (newN.value < P.value) {
            if (P.leftChild == null) {
                P.leftChild = newN;
                newN.parent = P;

            } else {
                insertInOrder(P.leftChild, newN);
            }

        } else if (P.rightChild == null) {
            P.rightChild = newN;
            newN.parent = P;
        } else {
            insertInOrder(P.rightChild, newN);
        }
    }

    public void LNRTransversal(Node N) {
        if (N == null) {
        } else {
            LNRTransversal(N.leftChild);
            System.out.print(N.value + ", ");
            //System.out.print("");
            LNRTransversal(N.rightChild);
        }

    }

    public void find() {
        System.out.println("Enter a number to find: ");
        int found = scan2.nextInt();
        Node current = root;
        boolean rt = false;
        int level = 0;
        while (current != null && rt == false) {
            if (current.value == found) {
                rt = true;
                level++;
            } else if (current.value > found) {
                current = current.leftChild;
                level++;
            } else {
                current = current.rightChild;
                level++;
            }
        }
        if (rt == true) {
            System.out.println("The number " + current.value + " is on level " + level);
            System.out.println("");
        } else {
            System.out.println("Number " + found + " not found");
        }

    }

    public void searchSuccessor() {
        System.out.println("Enter a number to find its successor: ");
        int getSucc = scan2.nextInt();
        Node current = root;
        boolean found = false;
        //Node successor = null;
        while (current != null && found == false) {
            if (current.value == getSucc) {
                getSuccessor(current);
                found = true;
            } else if (current.value > getSucc) {
                current = current.leftChild;

            } else {
                current = current.rightChild;
            }
        }

        if (found == false) {
            System.out.println("Element not found.");
        }
    }

    public void delete() {
        System.out.println("Enter number to be deleted: ");
        int deleted = scan2.nextInt();
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.value != deleted) {
            parent = current;
            if (current.value > deleted) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                System.out.println("Number " + deleted + " not found");
                return;
            }

        }
        //node found
        //deleted node has no children
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;

            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.leftChild != null && current.rightChild != null) {

            Node successor = moveSuccessor(current);
            if (current == root) {
                root = successor;

            } else if (isLeftChild) {
                parent.leftChild = successor;

            } else {
                parent.rightChild = successor;

            }
            successor.leftChild = current.leftChild;

        }

        nItems--;
        System.out.println(current.value + " was deleted from the tree");

    }

    public Node moveSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != deleteNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = deleteNode.rightChild;
        }
        return successor;
    }

    public void getSuccessor(Node getSucc) {
        Node successor = null;
        Node p = null;
        Node current = getSucc.rightChild;
        if (getSucc.value == findMax()) {
            System.out.println("No successor.");

        } else if (current == null) {
            p = getSucc.parent;
            current = getSucc;//set cur = leaf node
            while(current == p.rightChild && p != null){
                current = p;
                p = p.parent;
            }
            successor = p;
            System.out.println("The successor is: " + successor.value);

        } else {
            while (current != null) {
                p = successor;
                successor = current;
                current = current.leftChild;
            }
        }
        System.out.println("The successor is: " + successor.value);


    }

    public void display() {

        LNRTransversal(root);

    }

    public void printTree() {
        //for (int i = 1; i <= 31; i++) {

        //}
        for (int i = 1; i <= 31; i++) {
            if (aTree[i] != null) {
                aTree[i] = " . ";
            } else {
                aTree[i] = " / ";
            }

        }
        buildArray(root, 1);
        System.out.println("                                                      " + aTree[1] + "          ");
        System.out.println("                                                       |                                      ");
        System.out.println("                          " + aTree[2] + " -------------------------^----------------------- " + aTree[3] + " ");
        System.out.println("                           |                                                     | ");
        System.out.println("            " + aTree[4] + " -----------^----------- " + aTree[5] + "                       " + aTree[6] + " -----------^----------- " + aTree[7] + " ");
        System.out.println("             |                           |                         |                           |       ");
        System.out.println("     " + aTree[8] + " ----^---- " + aTree[9] + "           " + aTree[10] + " ----^---- " + aTree[11] + "         " + aTree[12] + " ----^---- " + aTree[13] + "           " + aTree[14] + " ----^---- " + aTree[15] + " ");
        System.out.println("      |             |             |             |           |             |             |             |    ");
        System.out.println(" " + aTree[16] + " -^- " + aTree[17] + "   " + aTree[18] + " -^- " + aTree[19] + "   " + aTree[20] + " -^- " + aTree[21] + "   " + aTree[22] + " -^- " + aTree[23] + " " + aTree[24] + " -^- " + aTree[25] + "   " + aTree[26] + " -^- " + aTree[27] + "   " + aTree[28] + " -^- " + aTree[29] + "   " + aTree[30] + " -^- " + aTree[31] + "  ");
        System.out.println("");
    }

    public void buildArray(Node p, int index) {
        if (p == null) {
            return;
        }
        if (index > 31) {
            return;
        }
        String int2string = Integer.toString(p.value);
        aTree[index] = int2string;
        buildArray(p.leftChild, index * 2);
        buildArray(p.rightChild, index * 2 + 1);

    }

    public void stats() {
        if (root == null) {
            System.out.println("Empty list"
                    + "\nTree Height: 0"
                    + "\nTree Root: none"
                    + "\nTree Count: 0");
        } else {
            display();
            System.out.println("");
            System.out.println("Tree Height: " + treeHeight(root));
            System.out.println("Tree Root: " + root.value);
            System.out.println("Tree Count: " + nItems);
        }
    }

    public int treeHeight(Node temp) {
        if (temp == null) {
            return 0;
        } else {
            return 1 + Math.max(treeHeight(temp.leftChild), treeHeight(temp.rightChild));
        }

    }

    public void balance() {
        sortArray();
        root = null;
        toBST();
        //System.out.println("Tree balanced");
    }

    public void toBST() {

        int[] balance = new int[nItems + 1];
        nItems = 0;
        int counter = 1;
        String sAdd;
        int iAdd;
        for (int i = 1; i < balance.length; i++) {
            sAdd = aTree[i];
            iAdd = Integer.parseInt(sAdd);
            balance[counter] = iAdd;
            counter++;
        }
        balanceRecur(1, balance.length, balance);
    }

    public void balanceRecur(int s, int e, int[] balance) {
        if (s == e) {
            return;
        }

        int middle = (s + e) / 2;
        add(balance[middle]);
        balanceRecur(middle + 1, e, balance);
        balanceRecur(s, middle, balance);
    }

    public void sortArray() {
        treeIndex = 0;
        toArray(root);
    }

    public void toArray(Node n) {
        if (n == null) {
        } else {
            toArray(n.leftChild);
            String intString = String.valueOf(n.value);
            treeIndex++;
            aTree[treeIndex] = intString;
            toArray(n.rightChild);
        }
    }

    public void newTree() {
        for (int i = 1; i <= 31; i++) {
            aTree[i] = " . ";

        }
        root = null;
        nItems = 0;
    }

    public int findMax() {
        Node temp = root;
        while (temp.rightChild != null) {
            temp = temp.rightChild;
        }
        return temp.value;
    }

}
