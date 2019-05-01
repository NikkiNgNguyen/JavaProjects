/*Audrey Kobayashi
  Nikki Nguyen
  November 27, 2017
  Purpose:insert strings and integers into a map
  Inputs: strings, alphabet, and value of each character
  Output: the value of a word
*/
package collections;

import java.util.*;
import java.io.*;

/**
 * class inserts the alphabet and a Scrabble value into a map to calculate the
 * score of a word
 * 
 * @author NikkiNguyen Audrey Kobayashi
 *
 */
public class ReadToMap {
	/**
	 * uses a key set to calculate the worth of a Scrabble word
	 * 
	 * @param args
	 * @throws IOException
	 */

	static HashMap<Character, Integer> mapVal = new HashMap<>();

	/**
	 * gives point value to scrabble word
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File("letter_value.txt"));
			while (file.hasNext()) {
				mapVal.put(file.next().charAt(0), Integer.parseInt(file.next()));
			}
		} catch (Exception fnf1) {
			fnf1.printStackTrace();
		}
		try {
			Scanner file2 = new Scanner(new File("words.txt"));
			while (file2.hasNext()) {
				String word = file2.nextLine();
				int score = 0;
				for (int i = 0; i < word.length(); i++)
					score += mapVal.get(word.charAt(i));
				System.out.println(word + "score: " + score);

			}
		} catch (Exception fnf) {
			fnf.printStackTrace();
		}
	}
}
