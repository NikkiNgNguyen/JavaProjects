/*Nikki Nguyen
  September 11, 2017
  Purpose: This program is used to change robot's location and direction
  Inputs: The user's choice in direction and movement
  Output: The robot's location and direction
*/
/**
 *robot class that creates 2 robots to follow commands given
 * @author NikkiNguyen
 */
public class robotChecker {
    //only this class can use these robots (declaring three robots)
    private static Robot robot1;
    private static Robot robot2;
    private static Robot robot3;
    public static void main(String args[]){
        //make robots
        robot1 = new Robot();
        robot2 = new Robot();
        robot3 = new Robot();
        //make robot 1 move
        System.out.println("robot 1:");
        robot1.turnLeft();
        robot1.move();
        robot1.move();
        robot1.turnLeft();
        robot1.move();
        robot1.move();
        robot1.move();
        robot1.move();
        robot1.turnLeft();
        robot1.turnRight();
        robot1.move();
        //make robot 2 move
        System.out.println("robot 2:");
        robot2.turnLeft();
        robot2.move();
        robot2.move();
        robot2.turnLeft();
        robot2.move();
        robot2.move();
        robot2.turnLeft();
        robot2.move();
        robot2.turnRight();
        robot2.turnRight();
        robot2.move();
        //make robot 3 move
        System.out.println("robot 3:");
        robot3.move();
        robot3.move();
        robot3.turnLeft();
        robot3.turnLeft();
        robot3.move();
        robot3.turnRight();
        robot3.move();
    }

}
