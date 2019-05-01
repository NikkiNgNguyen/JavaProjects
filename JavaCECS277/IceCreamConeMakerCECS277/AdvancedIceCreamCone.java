/*
   Nikki Nguyen
  October 23, 2017
  Purpose:model properties and behaviors of an ice cream cone
  Inputs: number of scoops, flavor, type of cone, toppings
  Output: ice cream cone with inputted properties
*/
/* This class is used to model the properties and behaviors of an ice cream cone.
   There are currently restriction on the construction of the cone: only one
   flavor of ice cream is allowed. */
import java.util.*;

public class AdvancedIceCreamCone {

    private int numberOfScoops;
    private String flavor;
    private String typeOfCone;
    private ArrayList<String> toppings = new ArrayList<String>();
    private double price;

//the default constructor creates a one scoop, vanilla ice cream cone using the regular type of cone and no toppings
    public AdvancedIceCreamCone() {
        numberOfScoops = 1;
        flavor = "vanilla";
        typeOfCone = "regular";
        price = 3.41;
    }

    /*this constructor lets you create an ice cream code to your liking. It takes in three parameters:
  the number of scoops, the flavor of the ice cream and the type of cone */
    public AdvancedIceCreamCone(int ns, String flv, String cone) {
        numberOfScoops = ns;
        flavor = flv;
        typeOfCone = cone;
    }
//this method returns the number of scoops in the cone

    public int getNumberOfScoops() {
        return numberOfScoops;
    }
//this method returns the ice cream flavor

    public String getFlavor() {
        return flavor;
    }
//this method returns the type of cone

    public String getTypeOfCone() {
        return typeOfCone;
    }
//this method allows you to add one scoop of ice cream at a time

    public void addScoop() {
        numberOfScoops = numberOfScoops + 1;
    }
//this method allows you to change the ice cream flavor

    public void setFlavor(String flv) {
        flavor = flv;
    }
//this method allows you to change the type of cone

    public void setTypeOfCone(String cone) {
        typeOfCone = cone;
    }
//this method allows you to add  toppings

    public void addToppings(String top) {
        toppings.add(top);
    }
    /**
     * sets price equal to base price * number of scoops
     * @param numberOfScoops
     */
    public void setPrice(double priceC){
        price = priceC;
    }
    /**
     * calculates the price per cone
     * @param numberOfScoops
     */
    public void calculatePrice(int numberOfScoops){
        price = price * numberOfScoops;
    }


//this method returns a String with a list of the toppings
    public ArrayList<String> getToppings() {
        return toppings;
    }

    /**
     * creates a memento with given properties
     * @return new cone with number of scoops, flavor, type of cone, and toppings
     */
    public MementoIceCreamCone createMemento(){
        return new MementoIceCreamCone(numberOfScoops, flavor, typeOfCone, toppings, price);
    }

    /**
     * gets the state of the memento
     * @param scoopMemento
     */
    public void getScoopMemento(MementoIceCreamCone scoopMemento){
        this.numberOfScoops = scoopMemento.getNumberOfScoops();
        this.flavor = scoopMemento.getFlavor();
        this.typeOfCone = scoopMemento.getTypeOfCone();
        this.toppings = scoopMemento.getToppings();
        this.price = scoopMemento.getPrice();

    }
    /**
     * returns price
     * @return price
     */
    public double getPrice(){
        return price;
    }

//this method overrides the inherited toString()
    @Override
    public String toString() {
        return ("The number of scoops is " + numberOfScoops + ". The flavor is "
                + flavor + ". And the type of cone is " + typeOfCone + " \nand the toppings are: " + getToppings()+ "\n");
    }

}
