import java.util.Scanner;
public class lab5 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double sum = 0;
        double max = 0;
        double min = 10;
        double average = 0;

        System.out.println("This program will calculate the average of 7 of 9 scores");
        System.out.println("Enter a score from 0.0 - 10.0");

        for(int i = 1; i <10; i++ ){
           System.out.println("Enter Judge #" + i + "'s Score:");
           double score = scan.nextDouble();


           if(score >= 0.0 && score <= 10.0){
                if(max < score){
                    max = score;
                }
                if(min > score){
                    min = score;
                }
            sum += score;
           }

        }
        average = (sum - max - min)/7;
        System.out.println("Your final score is " + average);




    }



}
