/*Audrey Kobayashi
  Nikki Nguyen
  November 27, 2017
  Purpose:Use a linked list to traverse through a list for a scavenger hunt and display the time it takes to do each task
  Inputs: number of teams and 100 items
  Output: Time it takes to run through the program
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

/**
 * class uses array lists to find the most efficient collection
 * @author NikkiNguyen Audrey Kobayashi
 *
 */
public class AL {
	/**
	 * main uses array lists to create a scavenger hunt
	 * @param args
	 */
	public static void main(String[] args){
		
		//Use an Iterator to traverse the Collection from beginning to end.
		//Then iterate through the Collection from end to beginning (backwards). 
		ArrayList<String> list = new ArrayList<>();
		long time1 = 0, time2;
		long startTime = System.nanoTime();
		Scanner in;
		try {
			
			time1 = System.currentTimeMillis();
			in = new Scanner(new File("100things.txt"));
			while(in.hasNextLine()){
				String s = in.nextLine();
				list.add(s);
			}	
			ListIterator it = list.listIterator();
			in.close();
			time1 = System.currentTimeMillis();
			while(it.hasNext()){it.next();}
			while(it.hasPrevious()){it.previous();}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			time2 = System.currentTimeMillis();
			System.out.println("Time to iterate through and back: " + (time2-time1));
			long estimatedTime = System.nanoTime() - startTime;
			System.out.println(estimatedTime);
		}
		
		//Ask the user how many teams will play the game. Create this number of teams. 
		//For each team load all of the items from the list. 
		//Shuffle the list after loading the items each time. 
		//Find the total time it takes to add the items to all of the teams.
		Scanner input = new Scanner(System.in);
		System.out.println("How many teams will play the game?");
		int teams = input.nextInt();
		ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
		time1 = System.currentTimeMillis();
		for(int i = 0; i < teams; i++){
			lists.add(new ArrayList<String>());
			lists.get(i).addAll(list);
			Collections.shuffle(lists.get(i));
		}
		time2 = System.currentTimeMillis();
		System.out.println("Time to add items to as many designated lists: " + (time2-time1));
		
	
		
		//Ask the user what position in the list to be used for retrieving and inserting elements. 
		//Retrieve that element from each of the teams. Find the total time it takes.
		time1 = System.currentTimeMillis();
		System.out.println("Which position in the list would you like to remove?");
		int num = input.nextInt();
		for(int i = 0; i < teams; i++){
			System.out.println("Retrieving item at position " + num + ": " + lists.get(i).get(num));
			lists.get(i).get(num);
		}
		time2 = System.currentTimeMillis();
		System.out.println("Time to remove a certain element from each list: " + (time2-time1));
		
		
		//Next insert a new element at that position in each of the lists. Find the total time it takes.
		time1 = System.currentTimeMillis();
		for(int i = 0; i < teams; i ++){
			lists.get(i).add(num, "brocolli");
		}
		time2 = System.currentTimeMillis();
		System.out.println("Time to add a certain element to each list: " + (time2-time1));
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime);

		
		
		//Use the Random class to generate a number between 0 and the 100. 
		//Find the element in the scavenger hunt list at that position. 
		//Retrieve that element from each of the lists. Find the total time it takes
		time1 = System.currentTimeMillis();
		Random rand = new Random();
		int randomInt = rand.nextInt(100);
		for(int i = 0; i < teams; i++){
			System.out.println("Retrieving item at position " + randomInt + ": "+ lists.get(i).get(randomInt));
		}
		time2 = System.currentTimeMillis();
		System.out.println("Time elaspsed after getting item at random position: " + (time2-time1));
		long estimatedTime1 = System.nanoTime() - startTime;
		System.out.println(estimatedTime1);
		
	}
}