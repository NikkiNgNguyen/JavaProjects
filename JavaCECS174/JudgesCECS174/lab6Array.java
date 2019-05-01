import java.util.*;
public class lab6Array {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        //store scores
        double[] scores = new double[9];
        //declare variables
        double sum = 0;
        double max = 0.0;
        double min = 10.0;
        double average;

        System.out.println("This program will calculate the average of 7 of 9 scores");
        System.out.println("Enter a score from 0 to 10.0");

        //take input of numbers
        for (int i = 1; i < 10; i++){
            System.out.println("Enter Judge #" + i + "'s score:");


            scores[i-1] = scan.nextDouble();

            //make sure scores are within range
            while((scores[i-1] < 0.0) || (scores[i-1] > 10.0)){
                System.out.println("Invalid input, it's like you didn't read the second sentence. Scroll up.");
                System.out.println("Try again, Dumbass.");
                System.out.println("Enter Judge #" + i + "'s score:");

                scores[i-1] = scan.nextDouble();
            }

            //find highest and lowest nums
            if(max < scores[i-1]){
                max = scores[i-1];
            }
            if(min > scores[i-1]){
                min = scores[i-1];
            }
            // get sum
            sum += scores[i-1];
        }

        //get average, uncomment to find sum, max, and min
        average = (sum - max - min)/7;
        System.out.println();
        System.out.println("sum="+ sum);
        System.out.println("max=" + max);
        System.out.println("min=" + min);

        //print array
        for(int i = 1; i < 10; i++){
            System.out.print(scores[i-1] + "  ");
        }

        System.out.println();
        System.out.println("OMG You're so amazing, it's like you figure skate or something...");
        System.out.printf("Your final score is like "+ "%.2f", average);
        System.out.println();
        System.out.println("GG no RE");
        System.out.println("");

    }
}
