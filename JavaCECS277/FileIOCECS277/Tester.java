/*Audrey Kobayashi
  Nikki Nguyen
  November 8, 2017
  Purpose: create tester that creates file and translates it
  Inputs: message 
  Output: translated message

*/

/**
 *public class tests file input/output
 * @author AudreyKobayashi 
 * @author NikkiNguyen
 */
import java.util.*;

public class Tester {

	/**
	 * gives user options
	 */
    public static void mainMenu() {
        System.out.println("What would you like to do?\n" +
                "[1] Send a message\n" +
                "[2] Read a message\n" +
                "[3] Exit");
    }

    /**
     * allow user to select language of message
     */
    public static void languageMenu(){
    	System.out.println("Select a language:\n" +
                "[1] English\n" +
                "[2] Vulcan\n" +
                "[3] Klingon\n" +
                "[4] Ferrengi\n" +
                "[5] Other");
    }

    /**
     * method checks if user input is within menu options
     * @param low
     * @param high
     * @return valid vs invalid range
     */
    public static int checkIntRange( int low, int high ) {
        Scanner in = new Scanner( System.in );
        int input = 0;
        boolean valid = false;
        while( !valid ) {
            if( in.hasNextInt() ) {
                input = in.nextInt();
                if( input <= high && input >=low ) {
                    valid = true;
                } else {
                    System.out.println( "Invalid Range." );
                }
            } else {
                in.next();
                System.out.println( "Invalid Input." );
            }
        }
        return input;
    }

    /**
     * main switch case that executes menu options
     * @param args
     * @throws InvalidLanguageException
     */
    public static void main(String[] args) throws InvalidLanguageException {
    	EarthText et = new EarthText();
        boolean mainInvalid = true;
        Scanner in = new Scanner(System.in);

        //main menu selection
        while(mainInvalid){
            mainMenu();
            int menuInput = checkIntRange(1, 3);
            switch(menuInput){
                case 1:
                    boolean sendInvalid = true;
                    languageMenu();
                    //language selection menu
                    while(sendInvalid){
                        int langInput = checkIntRange(1, 5);
                        char[] message;
                        String fileName;
                        switch (langInput){
                            //write to earth
                            case 1:
                                System.out.println("Write message to send:");
                                message = (in.nextLine()).toCharArray();
                                System.out.println("What would you like the file name to be?");
                                fileName = in.nextLine();
                                et.sendMessage("Earth", message, fileName);
                                System.out.println("Sent!");
                                break;
                            case 2:
                                System.out.println("Write message to send:");
                                message = (in.nextLine()).toCharArray();
                                System.out.println("What would you like the file name to be?");
                                fileName = in.nextLine();
                                et.sendMessage("Vulcan", message, fileName);
                                System.out.println("Sent!");
                                break;
                            case 3:
                                System.out.println("Write message to send:");
                                message = (in.nextLine()).toCharArray();
                                System.out.println("What would you like the file name to be?");
                                fileName = in.nextLine();
                                et.sendMessage("Klingon", message, fileName);
                                System.out.println("Sent!");
                                break;
                            case 4:
                                System.out.println("Write message to send:");
                                message = (in.nextLine()).toCharArray();
                                System.out.println("What would you like the file name to be?");
                                fileName = in.nextLine();
                                et.sendMessage("Ferrengi", message, fileName);
                                System.out.println("Sent!");
                                break;
                            case 5:
                            	System.out.println("Sorry, we only support Earth, Vulcan, Klingon, and Ferrengi.");
                            default:
                                break;
                        }
                        sendInvalid = false;
                    }
                    break;
                case 2:
                    boolean readInvalid = true;
                    languageMenu();
                    while(readInvalid){
                        int langInput = in.nextInt();
                        String fileName;
                        switch (langInput){
                            //read from earth
                            case 1:
                            	System.out.print("What is the file name?");
                            	fileName = in.next();
                                System.out.println("Message:");
                                et.readMessage("Earth", fileName);
                                break;
                            case 2:
                            	System.out.print("What is the file name?");
                            	fileName = in.next();
                                System.out.println("Message:");
                                et.readMessage("Vulcan", fileName);
                                break;
                            case 3:
                            	System.out.print("What is the file name?");
                            	fileName = in.next();
                                System.out.println("Message:");
                                et.readMessage("Klingon", fileName);
                                break;
                            case 4:
                            	System.out.print("What is the file name?");
                            	fileName = in.next();
                                System.out.println("Message:");
                                et.readMessage("Ferrengi", fileName);
                                break;
                            case 5:
                            	System.out.println("Sorry, we only support Earth, Vulcan, Klingon, and Ferrengi.");
                            default:
                                break;
                        }
                        readInvalid = false;
                    }
                    break;
                case 3:
                    System.out.println("Goodbye.");
                    mainInvalid = false;
                    break;
                default:
                    break;
            }
        }
    }
}