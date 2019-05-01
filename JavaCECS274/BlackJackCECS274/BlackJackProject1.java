/**
 *
 * @author NikkiNguyen
 * CECS 274-05
 * Prog 1 - Blackjack
 * 9/13/2016
 */
import java.util.*;

public class BlackJackProject1 {

    //amount to bet
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int bet;

        Deck myDeck = new Deck();
        //get y or n for more cards
        Scanner keyboard = new Scanner(System.in);

        //initilize dealer and user
        Player myHand = new Player();
        Player dealer = new Player();

        int menuChoice = 0;
        boolean stand = true;

        //make sure that the menu will keep redrawing, input validation
        while (menuChoice != 5) {
            menuChoice = menu();

            switch (menuChoice) {
                //create a new deck
                case 1:
                    System.out.println("");
                    System.out.println("New Deck Done");
                    System.out.println("");
                    myDeck = new Deck();

                    break;
                //shuffle deck
                case 2:
                    myDeck.shuffle();

                    break;
                //display deck and remaining cards
                case 3:
                    myDeck.display();
                    System.out.println("");
                    System.out.println("Cards Left: " + myDeck.cardsLeft());
                    System.out.println("");
                    //Deck myDeck = new Deck();
                    break;
                //actual game
                case 4:
                    // < 14 because when first deal, there will 4 cards passed out making it 9
                    if(myDeck.cardsLeft() < 14){
                        System.out.println("");
                        System.out.println("Remake deck");
                        System.out.println("");
                        break;
                    }

                    //ask for bet amount
                    //.getWallet returns the current value of the wallet
                    do {
                        System.out.println("");
                        System.out.println("How much do you bet? You have $" + myHand.getWallet());
                        bet = scan.nextInt();
                        if (bet < 0 || bet > myHand.getWallet()) {
                            System.out.println("Invalid Input, you have $" + myHand.getWallet());

                        }

                        //with a valid bet, play the game
                    } while (bet < 0 || bet > myHand.getWallet());
                    //use temp card to hold value
                    Card holder = myDeck.deal();
                    //cant see dealer's first card
                    holder.faceDown();
                    //dealer draws 2x
                    dealer.draw(holder);
                    holder = myDeck.deal();
                    dealer.draw(holder);

                    System.out.println("");
                    System.out.println("Dealer:     Total: ??? " /*+ dealer.getValue()*/);
                    System.out.println("");
                    //displays dealer's hand
                    dealer.display();

                    //draw 2x for user
                    holder = myDeck.deal();
                    myHand.draw(holder);
                    holder = myDeck.deal();
                    myHand.draw(holder);
                    System.out.println("");
                    System.out.println("My Hand:    Total: " + myHand.getValue());
                    System.out.println("");
                    myHand.display();

                    do {
                        //ask to hit = get a card, stay = start calculating values of hands
                        System.out.println("");
                        System.out.println("Hit or Stay?    H/S");

                        String more = keyboard.nextLine().toLowerCase();
                        if (more.equals("h")) {
                            //draw cards
                            myHand.draw(myDeck.deal());
                            System.out.println();
                            System.out.println("My Hand:    Total:  " + myHand.getValue());

                            System.out.println();
                            myHand.display();
                            //validate number of cards left to play with
                            if (myDeck.cardsLeft() < 10) {
                                System.out.println("");
                                System.out.println("Remake deck.    Cards left: " + myDeck.cardsLeft());
                                System.out.println("");
                                break;
                            }

                            //check win or lose
                        } else if (more.equals("s")) {
                            stand = false;
                        } else {
                            System.out.println("Invalid input, try again");

                        }
                    } while (stand && dealer.getValue() < 21 && myHand.getValue()<21);
                    //dealer will draw until it hits at least 17
                    while (dealer.getValue() < 17) {
                        dealer.draw(myDeck.deal());
                    }
                    //auto lose if user goes over 21
                    if (myHand.getValue() > 21) {
                        System.out.println("");
                        System.out.println("Dealer:      Total: " + dealer.getValue());
                        //flip dealer's card up
                        dealer.displayHand();

                        //update wallet
                        myHand.lose(bet);

                        System.out.println("");
                        System.out.println("You lose.");
                        System.out.println("Wallet: $" + myHand.getWallet());

                        //restart the game when the user runs out of money
                        if (myHand.getWallet() == 0) {
                            System.out.println("");
                            System.out.println("You have $0, restart the game.");

                            System.exit(0);

                        }

                    } else if (myHand.getValue() >= dealer.getValue() || dealer.getValue() > 21) {

                        System.out.println("");
                        System.out.println("Dealer:      Total: " + dealer.getValue());
                        //flip dealer's card up
                        dealer.displayHand();

                        //update wallet
                        myHand.win(bet);

                        System.out.println("");
                        System.out.println("You Win");
                        System.out.println("Wallet: $" + myHand.getWallet());
                        System.out.println("");

                        //if user's hand is less than dealer, lose
                    } else if (myHand.getValue() <= dealer.getValue()) {
                        System.out.println("");
                        System.out.println("Dealer:      Total: " + dealer.getValue());
                        dealer.displayHand();
                        //update bet
                        myHand.lose(bet);

                        System.out.println("");
                        System.out.println("You lose.");
                        System.out.println("Wallet: $" + myHand.getWallet());

                        //restart the game when the user runs out of money
                        if (myHand.getWallet() == 0) {
                            System.out.println("");
                            System.out.println("You have $0, restart the game.");

                            System.exit(0);

                        }

                    }
                    //goes back into the loop, if kept false, user would not be able to draw
                    stand = true;
                    //set the hands' values to 0 and empty hands so that next game can be played
                    myHand.setValue(0);
                    dealer.setValue(0);
                    myHand.emptyHand();
                    dealer.emptyHand();
                    break;

                //exit game
                case 5:
                    System.out.println("");
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

            }

        }
    }

    public static int menu() {

        int input;
        //Scanner scan = new Scanner(System.in);

        System.out.println("BlackJack, not Jack Black");
        System.out.println("Please select an option from the menu:");
        System.out.println("------------------------------------------------");
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
        System.out.println("| [1] New Deck                                 |");
        System.out.println("| [2] Shuffle Cards in Deck                    |");
        System.out.println("| [3] Display all Cards Remaining in Deck      |");
        System.out.println("| [4] Play Black Jack                          |");
        System.out.println("| [5] Quit                                     |");
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
        System.out.println("------------------------------------------------");
        input = scan.nextInt();
        while (input < 1 || input > 5) {
            System.out.println("Invalid Input, try again");
            input = scan.nextInt();
        }
        return input;
    }

}
