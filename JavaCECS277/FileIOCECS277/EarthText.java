/*Audrey Kobayashi
  Nikki Nguyen
  November 8, 2017
  Purpose: creates earth text class that implements advanced cell phone
  Inputs: language type, message, and file name
  Output: reads and sends text
*/

/**
 *class reads and sends text
 * @author AudreyKobayashi 
 * @author NikkiNguyen
 */
import java.io.*;
import java.util.Scanner;
public class EarthText implements AdvancedCellPhone{

	LanguageAdapter languageAdapter;
	
	/**
	 * sends message found on file
	 * @param languageType
	 * @param message
	 * @param fileName
	 */
	@Override
	public void sendMessage(String languageType, char[] message, String fileName) throws InvalidLanguageException {
		if(languageType.equalsIgnoreCase("earth")){
			try{
				PrintWriter write = new PrintWriter(new File(fileName));
				write.print(message);
				write.close();
			}catch(FileNotFoundException fnf){System.out.println("File not found.");}
	        }else if(languageType.equalsIgnoreCase("vulcan") || languageType.equalsIgnoreCase("ferengi") || languageType.equalsIgnoreCase("klingon")){
	            languageAdapter = new LanguageAdapter(languageType);
	            languageAdapter.sendMsg(languageType, message, fileName);
	        }else{
	            throw new InvalidLanguageException("Error: unknown language");
	        }
	}
	
	/**
	 * method reads message found on file
	 * @param languageType
	 * @param fileName
	 */
	@Override
	public void readMessage(String languageType, String fileName) throws InvalidLanguageException {
		if(languageType.equalsIgnoreCase("Earth")){
            try{
                Scanner in = new Scanner(new File(fileName));
                while(in.hasNextLine()){
                    System.out.println(in.nextLine());
                }
                in.close();
            }catch(FileNotFoundException fnf){
                System.out.println("File not found.");
            }
        }else if(languageType.equalsIgnoreCase("Vulcan") || languageType.equalsIgnoreCase("Klingon") ||languageType.equalsIgnoreCase("Ferrengi")){
            languageAdapter = new LanguageAdapter(languageType);
            languageAdapter.readMsg(languageType, fileName);
        }else{
            throw new InvalidLanguageException("Unknown language");
        }
	}
	
	/**
	 * override sendText does nothing
	 * @param languageType
	 * @param fileName
	 */
	@Override
	public void sendText(String languageType, String fileName) {
		//**do nothing**
	}
	/**
	 * override readText does nothing
	 * @param languageType
	 * @param fileName
	 */
	@Override
	public void readText(String languageType, String fileName) {
		//**do nothing**
	}
	/**
	 * override translateText does nothing
	 * @param languageType
	 * @param message
	 * @param fileName
	 */
	@Override
	public void translateText(String languageType, char[] message, String fileName) throws InvalidLanguageException {
		//**do nothing**
	}
}
