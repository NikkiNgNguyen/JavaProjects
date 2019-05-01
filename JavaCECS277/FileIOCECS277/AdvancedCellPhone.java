/*Audrey Kobayashi
  Nikki Nguyen
  November 8, 2017
  Purpose: creates blueprint of the AdvancedCellPhone class
  Inputs: language type and file name
  Output: methods that may be implemented by other classes

*/

/**
 *interface creates blueprint for CellPhone class that allows you to read and send earth/alien language
 * @author AudreyKobayashi 
 * @author NikkiNguyen
 */
public interface AdvancedCellPhone {
	public void sendMessage(String languageType, char[] message, String fileName) throws InvalidLanguageException; //Send Earth
	public void readMessage(String languageType, String fileName) throws InvalidLanguageException; //Read Earth
	public void sendText(String languageType, String fileName); //Send Alien
	public void readText(String languageType, String fileName); //Read Alien
	public void translateText(String languageType, char[] message, String fileName) throws InvalidLanguageException; //Translate Alien
}
