/*Nikki Nguyen
  September 21, 2017
  Purpose: This program will split a deck of 52 cards in half used to play the card game War
  Inputs: option if the user would like to run the program
  Output: Comparison between two cards for the highest value
*/
import java.util.ArrayList;//import arraylist
import java.util.Scanner; //get user input
/**
 *program runs through all cards until there are no more cards to play (driver program)
 * @author NikkiNguyen
 */
public class ArrayLists {
    static Scanner scan = new Scanner(System.in); //user input
    static Deck deck = new Deck(); //main deck
    static Deck hand1 = new Deck(); //player 1 deck "hand"
    static Deck hand2 = new Deck(); //player 2 deck "hand"
    static Deck addUp = new Deck();//add played cards for ties
    public static int outcome; //determines endgame: 1: player 1 wins 2: player 2 wins
    public static int forbiddenCase;
    public static boolean drive;
    /**
     * plays war or exits depending on user input
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int menuChoice = 0;
        while (menuChoice != 2){
            menuChoice = menu();
            switch(menuChoice){
                //calls the driver and auto-plays
                case 1:
                    System.out.println();
                    deck.addCards();//adds cards to the deck
                    deck.shuffle();//shuffles cards in the deck
                    //deal 26 cards for each player
                    for (int i = 0; i < 26;i++){
                        hand1.add(deck.deal());
                        hand2.add(deck.deal());
                    }
                    //shows size of each hand
                    System.out.println("Player 1 cards: " + hand1.cardsLeft());
                    System.out.println("Player 2 cards: "+ hand2.cardsLeft()+"\n");
                    //call the driver and play the game
                    warDriver(hand1,hand2);
                    break;
                //exit game
                case 2:
                    System.out.println("");
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
            }
        }

    }
    /**
     * makes a menu allowing user to play game or exit program
     * @return user input
     */
    public static int menu(){
        int input;
        System.out.println();
        System.out.println("Welcome to War");
        System.out.println("[1] Play War");
        System.out.println("[2] Exit");
        input = scan.nextInt();
        while (input < 1 || input > 2){
            System.out.println("Invalid input, try again");
            input = scan.nextInt();
        }
        return input;
    }

    /**
     * method runs through the two decks and compares highest card for each round
     * @param hand1 first hand
     * @param hand2 second hand
     */
    public static void warDriver(Deck hand1,Deck hand2){
        forbiddenCase = 0;
        //while hands do not have 0 cards, keep playing
        while((!hand1.isEmpty())||(!hand2.isEmpty())){
            //deals cards for player 1 and 2
            Card cp1 = hand1.deal();
            Card cp2 = hand2.deal();
            System.out.println("Player 1 hand: " + cp1);
            System.out.println("Player 2 hand: " + cp2);
            options();
            //if ranks are the same, call tie function and battle
            if(cp1.getRank() == cp2.getRank()){
                addUp.add(cp1); //add 2 cards
                addUp.add(cp2);
                tie(cp1, cp2);
                if(forbiddenCase == 1){
                    drive = false;
                }
            }else{
                //if player 1 card is greater than player 2 card
                if(cp1.getRank() > cp2.getRank()){
                    System.out.println("Player 1 wins");
                    addUp.add(cp1);
                    addUp.add(cp2);
                    hand1.toBottom(addUp);

                    System.out.println("Player 1 cards: " + hand1.cardsLeft());
                    System.out.println("Player 2 cards: "+ hand2.cardsLeft()+"\n");

                }
                else{
                    //if player 2 card is greater than player 1 card
                    System.out.println("Player 2 wins");
                    addUp.add(cp1);
                    addUp.add(cp2);
                    hand2.toBottom(addUp);

                    System.out.println("Player 1 cards: " + hand1.cardsLeft());
                    System.out.println("Player 2 cards: "+ hand2.cardsLeft()+"\n");

                }
            }

        }

    }

    /**
     * if player 1 and 2 have cards that match in value, play 3 cards faced down, battle
     * the 4th card, winner takes +10 cards
     * @param cp1
     * @param cp2
     * @return the winning hand
     */
    public static Deck tie(Card cp1, Card cp2){
        //end if not enough cards, player 2 wins
        forbiddenCase = 0;
        if (hand1.cardsLeft() < 4){
            System.out.println();
            System.out.println("Player 1 cards: " + hand1.cardsLeft());
            System.out.println("Player 2 cards: " + hand2.cardsLeft()+"\n");
            System.out.println("Not enough cards, Player 1 loses");
            forbiddenCase = 1;
            outcome = 2;
            outcomes();
            return hand2;
        }
        //player 1 wins due to lack of cards
        else if (hand2.cardsLeft() < 4){
            System.out.println();
            System.out.println("Player 1 cards: " + hand1.cardsLeft());
            System.out.println("Player 2 cards: " + hand2.cardsLeft()+"\n");
            System.out.println("Not enough cards, Player 2 loses");
            forbiddenCase = 1;
            outcome = 1;
            outcomes();
            return hand1;
        }//tie
        else if(hand1.cardsLeft() < 4 && hand2.cardsLeft() < 4){
            System.out.println();
            System.out.println("Player 1 cards: " + hand1.cardsLeft());
            System.out.println("Player 2 cards: " + hand2.cardsLeft()+"\n");
            System.out.println("No winner");
            forbiddenCase = 1;
            outcome = 3;
            outcomes();
        }
        //add 3 cards


        for(int i = 1; i < 4; i++){
            System.out.println("You play card: ??? of ???");
	    System.out.println("Player two plays card: ??? of ???");
	    addUp.add(hand1.deal());
            addUp.add(hand2.deal());
        }

        //deal the 4th cards face up
        cp1 = hand1.deal();
        cp2 = hand2.deal();
        System.out.println("Player 1 hand: " + cp1);
        System.out.println("Player 2 hand: " + cp2);
        //add cards to the pile = 2 cards
        addUp.add(cp1);
        addUp.add(cp2);

        //if tie, try again
        if(cp1.getRank() == cp2.getRank()){
            tie(cp1,cp2);
            //player 1 win
        }else if(cp1.getRank() > cp2.getRank()){
            System.out.println("Player 1 wins");
            //takes all the cards
            hand1.toBottom(addUp);//technically you win back your own cards then +5
            System.out.println("Player 1 cards: " + hand1.cardsLeft());
            System.out.println("Player 2 cards: " + hand2.cardsLeft()+"\n");
            return hand1;
        }else//player 2 win
            System.out.println("Player 2 wins");
            hand2.toBottom(addUp);
            System.out.println("Player 1 cards: " + hand1.cardsLeft());
            System.out.println("Player 2 cards: " + hand2.cardsLeft()+"\n");
            return hand2;
    }

    /**
     * possible outcomes when a hand is empty
     */
    public static void options(){
        //player 1 not enough cards
        if(hand1.isEmpty()){
                System.out.println();
                System.out.println("Player 1 cards: " + hand1.cardsLeft());
                System.out.println("Player 2 cards: " + hand2.cardsLeft()+"\n");
                System.out.println("Not enough cards, Player 1 loses");
                outcome = 2;
                outcomes();
            //player 2 not enough cards
            }else if(hand2.isEmpty()){
                System.out.println();
                System.out.println("Player 1 cards: " + hand1.cardsLeft());
                System.out.println("Player 2 cards: " + hand2.cardsLeft()+"\n");
                System.out.println("Not enough cards, Player 2 loses");
                outcome = 1;
                outcomes();
                //tie by both 0 cards
            }else if(hand1.isEmpty()&&hand2.isEmpty()){
                System.out.println();
                System.out.println("Player 1 cards: " + hand1.cardsLeft());
                System.out.println("Player 2 cards: " + hand2.cardsLeft()+"\n");
                System.out.println("No winner");
                outcome = 3;
                outcomes();
            }
    }
    /**
     * outputs game end based on case
     */
    public static void outcomes(){
        switch(outcome){
            case 1:
                System.out.println("Player 1 is the Winner");
                System.exit(0);
                break;
            case 2:
                System.out.println("Player 2 is the Winner");
                System.exit(0);
                break;
            case 3:
                System.out.println("Tie");
                System.exit(0);
                break;

        }
    }
}
