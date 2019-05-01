/*Nikki Nguyen
  Prog 3 Happy Numbers
  CECS 274-05
  10/18/2016
 */
import java.util.*;

public class Lab3 {

    //scan for menu choice
    static Scanner scan = new Scanner(System.in);
    //scan number to find happiness
    static Scanner keyboard = new Scanner(System.in);
    //scan to find min and max for option 2
    static Scanner smin = new Scanner(System.in);
    static Scanner smax = new Scanner(System.in);
    //keeps track of digits
    static ArrayList<Integer> list = new ArrayList<>();
    //keeps track of happy numbers
    static ArrayList<Integer> updateList = new ArrayList<>();

    public static void main(String[] args) {
        int menuChoice;
        int findNum;
        System.out.println("Welcome to the Happy Numbers Program");
        System.out.println("");
        while (true) {
            menuChoice = menu();
            switch (menuChoice) {
                case 1:
                    //shows happy sequence of number
                    System.out.print("Enter a positive integer: ");
                    findNum = keyboard.nextInt();

                    //check for negative number
                    while (findNum < 1) {
                        System.out.print("Positive integers only");
                        findNum = keyboard.nextInt();
                    }
                    //call function to find whether or not happy
                    isHappy(findNum);
                    break;

                case 2:
                    //show all happy numbers in a range
                    getRange();

                    break;

                case 3:
                    //exit
                    System.out.println("");
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

            }
        }
    }

    public static int menu() {
        int input;
        System.out.println();
        System.out.println("1) Show Happy Sequence for a number");
        System.out.println("2) Show all Happy Numbers in a range");
        System.out.println("3) exit");
        input = scan.nextInt();
        while (input < 1 || input > 3) {
            System.out.println("Invalid Input, try again");
            input = scan.nextInt();
        }
        return input;

    }
//option 1

    public static int isHappy(int num) {
        int counter = 0;
        //int findingNum = num;
        updateList.add(num);

        //if happy
        if (num == 1) {


            System.out.print("1 - Happy");
            System.out.println();
            list.clear();
            updateList.clear();
            return num;
        } else {
            System.out.print(num + ", ");
        }
        //math to find digits
        while (num >= 10) {
            int modNum = num;
            modNum = modNum % 10;
            num = num / 10;
            list.add(modNum);
        }

        if (num < 10) {
            list.add(num);
        }
        //squares integer
        //Iterator enables you to cycle through a collection, obtaining or removing elements.
        Iterator<Integer> addToList = list.iterator();
        while (addToList.hasNext()) {
            int eNum = addToList.next();
            eNum = eNum * eNum;
            counter += eNum;
        }

        list.clear();

        //unhappy numbers
        for (int i = 0; i < updateList.size(); i++) {
            if (updateList.get(i) == counter) {
                System.out.print(counter + " - Unhappy");
                System.out.println();
                updateList.clear();
                return 0;
            }
        }
        updateList.add(counter);

        //recursion statement
        return isHappy(counter);
    }

    //option 2, finds all happy numbers in list
    public static int happyList(int num) {

        int counter = 0;
        updateList.add(num);

        if (num == 1) {

            return 1;
        }
        //get dem digits boi, once its 10, then you can get whether or not 1
        do {
            while (num >= 10) {
                int modNum = num;
                modNum = modNum % 10;
                num = num / 10;
                //add the number to the list
                list.add(modNum);

            }
            //add to the list
            if (num < 10) {
                list.add(num);
            }
            //Iterator enables you to cycle through a collection, obtaining or removing elements.
            Iterator<Integer> addToList = list.iterator();
            while (addToList.hasNext()) {
                int eNum = addToList.next();
                eNum = eNum * eNum;
                counter += eNum;
            }
            //remove elements from arraylist
            list.clear();

            for (int i = 0; i < updateList.size(); i++) {
                if (updateList.get(i) == counter) {
                    list.clear();
                    updateList.clear();
                    return 0;
                }
            }
            updateList.add(counter);

            num = counter;
            counter = 0;
        } while (num != 1);

        if (num == 1) {
            //System.out.print(findingNum);
            list.clear();
            updateList.clear();
            return 1;
        }
        return 0;

    }

    public static void getRange() {
        int min, max;
        int c = 0;
        int width = 0;

        System.out.println("Enter a range of numbers to search for Happy Numbers");
        System.out.println("Enter lower limit: ");
        min = smin.nextInt();
        System.out.println("Enter upper limit: ");
        max = smax.nextInt();

        //check for negative number
        while (min < 1) {
            System.out.println("Positive integers only");
            min = smin.nextInt();
        }
        //check if max is less than the min
        if (max < min) {
            System.out.println("Maximum must be larger than the minimum");
            max = smax.nextInt();
        }
        //find the width of the digits
        System.out.println("Here are the happy numbers: ");
        for (int i = min; i <= max; i++) {
            width = (int) (Math.log10(c) + 1);

            happyList(i);

            if (happyList(i) < 1) {
                c++;
                System.out.print(".");

            } else {
                if (i < 10){
                    c++;
                }
                if (i < 10) {
                    c++;
                } else if (i > 10 && i < 100) {
                    c = c + 2;
                } else if (i > 99 && i < 999) {
                    c = c + 3;

                } else if (i > 999) {
                    c = c + 4;
                }

                System.out.print(i);

            }
            if (width >= 3) {
                System.out.println();
                c = 0;
            }

        }

    }
}
