/*Audrey Kobayashi
  Nikki Nguyen
  November 8, 2017
  Purpose: creates a custom exception class 
  Inputs: a string
  Output: declared exception which is an invalid language

*/

/**
 * custom exception declared is when a string is in an invalid 
 * @author AudreyKobayashi 
 * @author NikkiNguyen
 */
public class InvalidLanguageException extends Exception {
	public InvalidLanguageException(){
	}
	public InvalidLanguageException(String s){
		super(s);
	}
}
