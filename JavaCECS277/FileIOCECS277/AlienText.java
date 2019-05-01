/*Audrey Kobayashi
  Nikki Nguyen
  November 8, 2017
  Purpose: creates alien text class that implements advanced cell phone
  Inputs: language type, message, and file name
  Output: reads and translated text

*/

/**
 *class reads and translates text
 * @author AudreyKobayashi 
 * @author NikkiNguyen
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AlienText implements AdvancedCellPhone{

	/**
	 * override send message but does nothing
	 */
	@Override
	public void sendMessage(String languageType, char[] message, String fileName) throws InvalidLanguageException {
		//do nothing
	}

	/**
	 * override read message but does nothing
	 */
	@Override
	public void readMessage(String languageType, String fileName) {
		//do nothing
	}

	/**
	 * override send text but does nothing
	 */
	@Override
	public void sendText(String languageType, String fileName) { 
		//do nothing
	}
	
	/**
	 * method reads file and throws exception if not found
	 * @param languageType
	 * @param fileName
	 */
	@Override
	public void readText(String languageType, String fileName) {
		 try{
	        Scanner in = new Scanner(new File(fileName));
	        while(in.hasNextLine()){System.out.println(in.nextLine());}
	            in.close();
	     }catch(FileNotFoundException fnf){System.out.println("File not found.");}
	}

	/**
	 * method sets algorithm to translate languages, throws exception when language unknown or file not found
	 * @param languageType
	 * @param message
	 * @param fileName
	 */
	@Override
	public void translateText(String languageType, char[] message, String fileName) throws InvalidLanguageException {
	
		try{
            if(languageType.equalsIgnoreCase("Klingon")){
                System.out.println("Translating to Klingon...");
               for(int i = 0; i < message.length-1; i++){
                    char temp = message[i];
                    char c1 = message[i++];
                    message[i] = c1;
                    message[i++] = temp;
                }
                PrintWriter write = new PrintWriter(new File(fileName));
                write.println(message);
                write.close();
            }else if(languageType.equalsIgnoreCase("Vulcan")){
                System.out.println("Translating to Vulcan");
                for(int i = 0; i < message.length-1; i++){
                    char temp = message[(i*message.length+1) % message.length];
                    char c1 = message[i++];
                    message[i] = c1;
                    message[i++] = temp;
                }
                PrintWriter write = new PrintWriter(new File(fileName));
                write.println(message);
                write.close();
            }else if(languageType.equalsIgnoreCase("Ferrengi")){
                System.out.println("Translating to Ferrengi");
                for(int i = 0; i < message.length-1; i++){
                    char temp = message[(((int)Math.pow((double)i, 3.0) + 20) % message.length)];
                    char c1 = message[i++];
                    message[i] = c1;
                    message[i++] = temp;
                }
                PrintWriter write = new PrintWriter(new File(fileName));
                write.println(message);
                write.close();
            }else{
                throw new InvalidLanguageException("Error: unknown language");
            }

        }catch(FileNotFoundException fnf){
            System.out.println("File not found.");
        }
		
	}
}