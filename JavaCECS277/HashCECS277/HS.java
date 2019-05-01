/*Audrey Kobayashi
  Nikki Nguyen
  November 27, 2017
  Purpose:Use a hash set to insert words from text file to hash set and search for a word 100 times
  Inputs: Alice in Wonderland text file
  Output: Time it takes to run through the program
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
/**
 * class reads text file and inserts words into a hash set 
 * @author NikkiNguyen Audrey Kobayashi
 *
 */
class HS{
	/**
	 * scans file and prints out time to insert and search for words
	 * @param args
	 */
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<String>();
        long time1, time2;
        time1 = System.nanoTime();
        try {
            Scanner in = new Scanner(new File("Alice.txt"));
            in.delimiter();
            while (in.hasNext()){
                String s = in.next();
                hs.add(s);
        }
        in.close();
        }catch(Exception f){
        }finally{time2 = System.nanoTime();
            System.out.println("Time for the operation is: " + (time2-time1));}

        time1 = System.nanoTime();
        try{
            for(int i = 0; i < 100; i++){
                hs.contains("etext");}
        }catch(Exception e){}
        finally{
            time2 = System.nanoTime();
            System.out.println("Searching for a word 100 times: " + (time2-time1));
            System.out.println("Although hash sets do not guarantee a constantly ordered insertion.\n It is definitely faster than a Tree set in inserting data from a text file to a set");
        }
    }
}
