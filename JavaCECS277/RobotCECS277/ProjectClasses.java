/*Nikki Nguyen
  September 11, 2017
  Purpose: This program is used to change robot's location and direction
  Inputs: The user's choice in direction and movement
  Output: The robot's location and direction
*/
//scans for user input
import java.util.Scanner;

/**
 * Menu program that takes users input to control one of 2 robots
 * @author NikkiNguyen
 */
public class ProjectClasses {
    //scan user input
    static Scanner scan = new Scanner(System.in);
    //will decide which robot to use
    public static Robot robot1;
    public static Robot robot2;
    public static Robot curRobot;

    /**
     *depending on the user input, the robot will either move
     * forward or change direction; exit program available
     * @param args
     */
    public static void main(String[] args) {

        //make the robots
        robot1 = new Robot();
        robot2 = new Robot();
        System.out.println("Welcome to Mr.Robot");
        //user input to make robot move
        int moveChoice;
        //while input is in bounds, do this
        activeMenu();
        do{
            moveChoice = moveMenu();
            switch(moveChoice){
                case 1:
                    curRobot.turnLeft();
                    break;
                case 2:
                    curRobot.turnRight();
                    break;
                case 3:
                    curRobot.move();
                    break;
                case 4:
                    //return to choose different robot
                    activeMenu();
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
            }
        }

        while(moveChoice != 5);
    }

    /**
     * menu that chooses which robot will be controlled
     */
    public static void activeMenu(){
         //declare user input to choose object
        int robotChoice;
        robotChoice = robotMenu();
        switch(robotChoice){
            case 1:
                System.out.println("robot 1 active");
                curRobot = robot1;
                break;
            case 2:
                System.out.println("robot2 active");
                curRobot = robot2;
                break;
            case 3:
                System.out.println("");
                System.out.println("Goodbye!");
                System.exit(0);
                break;
        }
    }

    /**
     * give user options to use robot 1 or robot 2
     * @return user input on robot option
     */
    public static int robotMenu(){
        int key;
        System.out.println("");
        System.out.println("1) Robot 1");
        System.out.println("2) Robot 2");
        System.out.println("3) Exit");
        key = scan.nextInt();
        //if the input is out of bounds, rerun the user input
        while(key < 1 || key > 3){
            System.out.println("Invalid Input, Try Again");
            key = scan.nextInt();
        }
        return key;
    }

    /**
     * gives user list of options on how to operate the program
     * @return user input on move option
     */
    public static int moveMenu(){
        int input;
        System.out.println("");
        System.out.println("1) Face Left");
        System.out.println("2) Face Right");
        System.out.println("3) Move Forward");
        System.out.println("4) Reselect Robot");
        System.out.println("5) Exit");
        input = scan.nextInt();
        //if the input is out of bounds, rerun the user input
        while(input < 1 || input > 5){
            System.out.println("Invalid Input, Try Again");
            input = scan.nextInt();
        }
        return input;
    }


}
   
