
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author NikkiNguyen
 */
public class Lab10 {

    public static void main(String[] args) {
        DecimalFormat money = new DecimalFormat("0.00");
        // create scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the name of the snack you want: ");
        String snackName = scan.nextLine();
        System.out.println("Input the mothafuckin price of the mothafuckin snack: ");
        double snackPrice = scan.nextDouble();
        System.out.println("Input the number of snacks in the vendy machine");
        int snackInventory = scan.nextInt();

        SnackMachine snacks = new SnackMachine(snackName, snackInventory, snackPrice);


        while (true) {
            System.out.println(snacks.toString());
            System.out.println("Enter money for sneks ples, 0 to quit");
            double uMoney = scan.nextDouble();
            if (uMoney < 0){
                System.out.println("invalid monies");
                System.out.println("Enter monies ples");
                uMoney = scan.nextDouble();
            }
            if (uMoney == 0) {
                break;
            }
            double result = snacks.purchaseItem(uMoney);
            if (result == -1) {
                System.out.println("Not enough monies");

            } else if (result == -2) {
                System.out.println("There are no more sneks, pls leave");
                break;
            } else {
                System.out.println("Goodbye, bro");
                System.out.println("Your change is $" + money.format(result));
            }

        }

    }
}
