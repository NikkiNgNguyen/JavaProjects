import java.util.*;
import java.text.*;
//program that does stuff
public class driveMyCar {
static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {


        //display menu
        System.out.println("Main Menu:");
        System.out.println("1. Travel Time");
        System.out.println("2. Cost of Gas");
        System.out.println("3. Used Value");
        System.out.println("4. Stopping Distance");
        System.out.println("5. Run away and never return");
        System.out.println("Choose a function: ");

        //select option
        int option = scan.nextInt();
        switch(option){
            case 1:
                System.out.println("");
                System.out.println("You have selected option #1. Travel Time.");
                travelTimeMenu();
                break;
            case 2:
                System.out.println("");
                System.out.println("You have selected option #2. Cost of Gas.");
                gasCostMenu();
                break;
            case 3:
                System.out.println("");
                System.out.println("You have selected option #3. Used Value.");
                carValueMenu();
                break;
            case 4:
                System.out.println("");
                System.out.println("You have selected option #4. Stopping Distance.");
                stopDistanceMenu();
                break;
            case 5:
                System.out.println("");
                System.out.println("Layta Betch");
                System.exit(0);
                break;
            default:
                System.out.println("");
                System.out.println("Invalid input, slow down there speed racer, don't go too far in life.");
                System.out.println("Rerun da program");
                break;
        }
    }
    public static void travelTimeMenu(){
        int minInHour = 60;
        double time, minTime;

        System.out.println("Enter travel distance, gurl (miles):");
        double distance = scan.nextDouble();
        // positive distance only
        while(distance <= 0){
            System.out.println("positive miles only:");
            distance = scan.nextDouble();

        }
        System.out.println("Enter speed (miles per hour):");
        double rate = scan.nextDouble();
        // positive rate only
        while(rate <= 0){
            System.out.println("positive rates only:");
            rate = scan.nextDouble();
        }
        time = timeToTravel(distance, rate);
        minTime = time * minInHour;
        System.out.printf("It takes " + "%.2f", minTime);
        System.out.printf(" minutes to travel " + "%.2f", distance);
        System.out.print(" miles at " + rate + " miles per hour");
        System.out.println("");


    }
    //calculates time
    public static double timeToTravel(double distance, double rate){
        double time;
        time = distance/rate;
        return time;
    }

    public static void gasCostMenu(){
        double mileage1, mileage2, costPerGal1,
                costPerGal2, milesPerMonth, savings;

        System.out.println("Enter Car 1's mileage:");
        mileage1 = scan.nextDouble();

        while(mileage1 <= 0){
            System.out.println("positive miles only:");
            mileage1 = scan.nextDouble();
        }
        System.out.println("Enter Car 1's average gas cost per gallon:");
        costPerGal1 = scan.nextDouble();
        while(costPerGal1 <= 0){
            System.out.println("positive $$$ only:");
            costPerGal1 = scan.nextDouble();
        }
        System.out.println("Enter Car 2's mileage:");
        mileage2 = scan.nextDouble();
        while(mileage2 <= 0){
            System.out.println("By now, your dumbass should realize it's positive miles only:");
            mileage2 = scan.nextDouble();
        }

        System.out.println("Enter Car 2's average gas cost per gallon:");
        costPerGal2 = scan.nextDouble();
        while (costPerGal2 <= 0){
            System.out.println("Way to go, Einstein, you've entered a shit input, positive $$$ only:");
            costPerGal2 = scan.nextDouble();
        }

        System.out.println("How many miles u drive a month????");
        milesPerMonth = scan.nextDouble();
        while (milesPerMonth <= 0){
            System.out.println("Positive miles por favor:");
            milesPerMonth = scan.nextDouble();
        }
        double annualCost1 = annualGasCost(mileage1, costPerGal1, milesPerMonth);
        double annualCost2 = annualGasCost(mileage2, costPerGal2, milesPerMonth);

        if (annualCost1 < annualCost2){
            savings = annualCost2 - annualCost1;
            DecimalFormat money = new DecimalFormat("0.00");
            System.out.println("Car 1 saves you $" + money.format(savings) + " per year compared to dat loser car. Did VTEC kick in?");
        }

        else if (annualCost1 > annualCost2){
            savings = annualCost1 - annualCost2;
            DecimalFormat money = new DecimalFormat("0.00");
            System.out.println("Car 2 saves you $" + money.format(savings) + " per year compared to dat ricer. JDM 4 lyfe!");
        }

        else{
            System.out.println("4 + 5 = 6 + 3, dem cars cost the same. ");
        }

    }
    public static double annualGasCost(double mileage,
            double costPerGal, double miles){


        int monthsInYear = 12;


        double time = miles/mileage;
        double savings = monthsInYear * time * costPerGal;
        return savings;


    }


    public static void carValueMenu(){
        double depreciation = .18;
        double originalPrice;
        int numOfYears;


        System.out.println("Enter the car's original price:");
        originalPrice = scan.nextDouble();
        while(originalPrice <= 0){
            System.out.println("You're so dense, light bends around you. The value must be greater than or equal to a dollar:");
            originalPrice = scan.nextInt();

        }
        System.out.println("Enter number of years you want to see tracked:");
        numOfYears =  scan.nextInt();
        numOfYears ++;
        while(numOfYears <= 1){
            System.out.println("Number of years must be greater than 0:");
            numOfYears = scan.nextInt();
        }
        double[] carValue;
        carValue = new double[numOfYears];
        for (int i = 1; i < numOfYears; i++){
            double newPrice = originalPrice * depreciation;
            originalPrice = originalPrice - newPrice;
            carValue[i] = originalPrice;
            DecimalFormat money = new DecimalFormat("0.00");
            System.out.println("Year " + i + " value: $" + money.format(carValue[i]));
        }

    }
    public static void stopDistanceMenu(){
        double frictionCoefficient, stopDistance, initialSpeed;
        int secInHour = 3600, feetInMile = 5280;
        String condition;

        System.out.println("Enter car's initial speed (miles per hour):");
        initialSpeed = scan.nextDouble();
        while (initialSpeed <= 0){
            System.out.println("Car's speed must be greater than 0:");
            initialSpeed = scan.nextDouble();

        }
        double velocity = (initialSpeed / secInHour) * feetInMile;


        System.out.println("Enter the condition of the tires (1 = New, 2 = Good, 3 = Poor):");
        int tireCondition = scan.nextInt();
        while (tireCondition <= 0 || tireCondition > 3){
            System.out.println("There are only THREE options for tire condition (1 = New, 2 = Good, 3 = Poor):");
            tireCondition = scan.nextInt();
        }
        if (tireCondition == 1){
            frictionCoefficient = .8;
            condition = "new";

        }
        else if (tireCondition == 2){
            frictionCoefficient = .6;
            condition = "good";

        }
        else{
            frictionCoefficient = .5;
            condition = "poor";

        }
        stopDistance = stoppingDistance(velocity, frictionCoefficient);
        System.out.printf("At " + initialSpeed + " miles per hour, with " + condition
        + " tires, the car will stop in " + "%.2f", stopDistance);
        System.out.print(" feet. Vroom, Vroom, MutherFucka");
        System.out.println("");
    }

    //calculates stopping distance
    public static double stoppingDistance(double velocity, double frictionCoefficient){
        double stopDistance;
        double feetInMeter = 3.280840;
        double accGravity = 9.80665; //m/s^2

        int kinEnergy = 2;

        double accGravityFt = accGravity * feetInMeter;

        stopDistance = (velocity*velocity)/(kinEnergy * frictionCoefficient * accGravityFt);

        return stopDistance;
    }
}
