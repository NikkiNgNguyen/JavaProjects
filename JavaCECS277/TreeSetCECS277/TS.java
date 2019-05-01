/*Audrey Kobayashi
  Nikki Nguyen
  November 27, 2017
  Purpose:Use a tree set to insert words from text file to tree set and search for a word 100 times
  Inputs: Alice in Wonderland text file
  Output: Time it takes to run through the program
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * class reads text file and inserts words into a tree set
 * @author NikkiNguyen Audrey Kobayashi
 *
 */
public class TS {
	/**
	 * scans file and prints out time to insert and search for words
	 * @param args
	 */
    public static void main(String[] args){
        TreeSet<String> ts = new TreeSet<String>();
        long time1, time2;
        time1 = System.nanoTime();
        {
        try {
            Scanner in = new Scanner(new File("Alice.txt"));
            in.delimiter();
            while (in.hasNext()){
                String s = in.next();
                ts.add(s);
            }
            in.close();
        }catch(FileNotFoundException f){
        }finally{time2 = System.nanoTime();
            System.out.println("Time for the operation is: " + (time2-time1));}
        }
        time1 = System.nanoTime();
        try{
            for(int i = 0; i < 100; i++){
                ts.contains("etext");}
        }catch(Exception e){}
        finally{
            time2 = System.nanoTime();
            System.out.println("Searching for a word 100 times: " + (time2-time1));
            System.out.println("Tree sets offer natural ordering and is considerably slower than a hash set.\n Although, Tree sets are much faster at searching because of the tree shape which will often have similar data near each other.");

        }
    }
}