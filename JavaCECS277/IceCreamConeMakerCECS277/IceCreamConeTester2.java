/*Nikki Nguyen
  October 23, 2017
  Purpose:tests the functions of the advanced ice cream cone class
  Inputs: inputting new objects, given flavor, number of scoops, type of cone, toppings
  Output: an ice cream cone object that is updated per instruction
 */
/**
 * This class tests the file reading/writing of the ice cream cone and outputs current object
 *
 * @author NikkiNguyen
 */
import java.io.IOException;
public class IceCreamConeTester2 {
    /**
     * main that outputs the ice cream cone tester
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //create objects
        CareTakerAction careTaker = new CareTakerAction();
        AdvancedIceCreamCone ICC = new AdvancedIceCreamCone();
        System.out.println(ICC);
        System.out.println("The base price per scoop is: " + ICC.getPrice());
        System.out.println("Adding scoop...");
        ICC.addScoop();//add scoop
        System.out.println("Current Status: "+ICC);
        System.out.println("Changing flavor...");
        ICC.setFlavor("chocolate");//set flavor
        System.out.println("Current Status: "+ICC);
        System.out.println("Adding toppings");
        String[] toppings = {"chocolate chips", "oreos","cherry","almonds","graham crackers"};//add string of toppings
        for(int i = 0; i < toppings.length; i++){
            ICC.addToppings(toppings[i]);
        }
        System.out.println("Current Status: "+ICC);
        System.out.println("Changing cone...");
        ICC.setTypeOfCone("sugar");
        System.out.println("Current Status: "+ ICC);
        System.out.println("Saving Ice Cream Cone...");
        careTaker.addMemento(ICC.createMemento());//save cone as memento
        System.out.println("Creating new Ice Cream Cone...");
        ICC = new AdvancedIceCreamCone(3,"Mimi's Minty", "waffle");//create new cone
        System.out.println("Current Status: " + ICC);
        System.out.println("Adding toppings...");
        ICC.addToppings("chocolate sauce");
        ICC.addToppings("whipped cream");
        System.out.println("Current Status: "+ ICC);
        System.out.println("Restore previous flavor...");
        ICC.getScoopMemento(careTaker.getMemento("chocolate"));//restore previous cone
        System.out.println("Previous status: " + ICC);
        System.out.println("Adding scoop...");
        ICC.addScoop();
        System.out.println("Current Cone: " + ICC);
        System.out.println("Toppings are free!");
        ICC.calculatePrice(ICC.getNumberOfScoops());
        System.out.println("Total cost: " + ICC.getPrice());
        System.out.println("Current Cone: " + ICC);

    }
}
