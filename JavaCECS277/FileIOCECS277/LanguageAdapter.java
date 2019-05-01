/*Audrey Kobayashi
  Nikki Nguyen
  November 8, 2017
  Purpose: creates language adapter class that implements the cellphone interface
  Inputs: file message and name
  Output: methods that read and send messages 

*/

/**
 *public class that reads and sends messages and implements cellphone
 * @author AudreyKobayashi 
 * @author NikkiNguyen
 */
public class LanguageAdapter implements CellPhone{
	AdvancedCellPhone acp;
	/**
	 * method creates a new file
	 * @param languageType
	 */
	public LanguageAdapter(String languageType){
         if(languageType.equalsIgnoreCase("Earth")){
        	 acp = new EarthText();}
         else if (languageType.equalsIgnoreCase("Vulcan") || languageType.equalsIgnoreCase("Klingon") || languageType.equalsIgnoreCase("Ferrengi")){
	         acp = new AlienText();}
    }
	/**
	 * method sends message 
	 * @param languageType
	 * @param [] message
	 * @param fileName
	 */
	@Override
	public void sendMsg(String languageType, char[] message, String fileName) throws InvalidLanguageException {
		if(languageType.equalsIgnoreCase("Earth")){
	         acp.sendMessage(languageType, message, fileName);}
		else if(languageType.equalsIgnoreCase("Vulcan") || languageType.equalsIgnoreCase("Klingon") || languageType.equalsIgnoreCase("Ferrengi")){
	         acp.translateText(languageType, message, fileName);}
	}
	/**
	 * method reads message 
	 * @param languageType
	 * @param fileName
	 */
	@Override
	public void readMsg(String languageType, String fileName) throws InvalidLanguageException {
		if(languageType.equalsIgnoreCase("Earth")){
	         acp.readMessage(languageType, fileName);}
		else if(languageType.equalsIgnoreCase("Vulcan") || languageType.equalsIgnoreCase("Klingon") || languageType.equalsIgnoreCase("Ferrengi")){
	         acp.readText(languageType, fileName);}
	}
}
