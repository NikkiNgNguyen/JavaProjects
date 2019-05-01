/*Audrey Kobayashi
  Nikki Nguyen
  November 8, 2017
  Purpose: creates blueprint of the CellPhone class
  Inputs: language type and file name
  Output: methods that may be implemented by other classes

*/

/**
 *interface creates blueprint for CellPhone class
 * @author AudreyKobayashi 
 * @author NikkiNguyen
 */
public interface CellPhone {
	public void sendMsg(String languageType, char[] message, String fileName) throws InvalidLanguageException;
	public void readMsg(String languageType, String fileName) throws InvalidLanguageException;
}
