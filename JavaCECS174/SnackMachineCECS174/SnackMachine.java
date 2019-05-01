/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NikkiNguyen
 */
// Represents a snack machine containing a single type of snack at a
// specific price.
import java.text.*;
public class SnackMachine {
   // A SnackMachine has three data members: # of snacks left in inventory,
   // and price of the snack, and the name of the snack.

   private int mInventoryCount;
   private double mPrice;
   private String mName;


   // To construct a SnackMachine, we must know its name, inventory count,
   // and price.
   public SnackMachine(String name, int count, double price) {
      mName = name;
      mInventoryCount = count;
      mPrice = price;
   }

   // Accessor and mutator for the snack's name.
   public String getName() {
      return mName;
   }

   public void setName(String name) {
      mName = name;
   }

   // Purchase an item from the snack machine, by inserting the given amount of
   // money.
   //
   // If the machine has 0 inventory, then the method returns -2.
   //
   // If the money inserted is not enough to afford the machine, then
   // the method returns -1.

   // Otherwise, the machine's inventory count goes down
   // by one, and we return how much change the user should receive.
   public double purchaseItem(double money) {
      if (mInventoryCount == 0){
          return -2;
      }
      else if (money >= mPrice) {
         mInventoryCount--;
         return money - mPrice;
      }
      else {
         return -1;
      }
   }

   // Increases the machine's inventory count, if the given integer is positive.
   public void addInventory(int count) {
      if (count > 0) {
         mInventoryCount += count;
      }
   }
   public double getPrice(){
       return mPrice;
   }
   public void setPrice(double price){
       if (price > 0){
           mPrice = price;
       }
   }

   public String toString(){
       DecimalFormat money = new DecimalFormat("0.00");
       return mName + ": " + mInventoryCount + " @ $" + money.format(mPrice);
   }


}
