/*Nikki Nguyen
  September 11, 2017
  Purpose: This program is used to change robot's location and direction
  Inputs: The user's choice in direction and movement
  Output: The robot's location and direction
*/
/**
 * public class Point represents points in two-dimensional (x,y) space
 */
import java.awt.Point;
/**
 *
 * This program creates a robot that will follow the user's commands, faces cardinal directions and moves forward
 * @author Nikki Nguyen, 014682900
 */
public class Robot {
    //declares point for robot location
    private final Point point;
    //declares the direction as a string (cardinal direction)
    private String direction;

    /**
     * This constructor sets a location and direction for the robot
     * @param x
     * @param y
     */
    public Robot(){
        //Starting point is south
        point = new Point(0,0);
        //robot initially facing North
        direction = "North";
    }

    /**
     * This method will make robot face different direction (left)
     */
    public void turnLeft(){
        if(direction.equals("North")){
            direction = "West";
        }
        else if(direction.equals("West")){
            direction = "South";
        }
        else if(direction.equals("South")){
            direction = "East";
        }
        else if(direction.equals("East")){
            direction = "North";
        }
        System.out.println(toString());

    }

    /**
     * This method will make robot face different direction (right)
     */
    public void turnRight(){
        //System.out.println("Robot's current direction:" + direction);
        if(direction.equals("North")){
            direction = "East";
        }
        else if(direction.equals("East")){
            direction = "South";
        }
        else if(direction.equals("South")){
            direction = "West";
        }
        else if(direction.equals("West")){
            direction = "North";
        }
        System.out.println(toString());
    }

    /**
     *  make the robot move 1 space forward and calls toString to print the object
     */
    public void move(){
        if(direction.equals("South")){
            point.y--;
            System.out.println(toString());
        }
        else if(direction.equals("North")){
            point.y++;
            System.out.println(toString());
        }
        else if(direction.equals("West")){
            point.x--;
            System.out.println(toString());
        }
        else if(direction.equals("East")){
            point.x++;
            System.out.println(toString());
        }
    }

    /**
     * @return the location of the robot
     */
    public Point getLocation(){
        return point;
    }
    /**
     *
     * @return the direction the robot is facing
     */
    public String getDirection(){
        return direction;

    }

    /**
     * overrides the toString function to print out location/direction
     * @return a string that tells the user the location and direction of the robot
     */
    @Override
    public String toString(){
        return("The robot is currently at " + ("("+point.x+","+point.y+")") + "\nIt is facing: " + direction +  "\n");
    }
}
