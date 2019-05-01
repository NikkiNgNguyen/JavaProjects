/*Nikki Nguyen
  September 21, 2017
  Purpose: This program will split a deck of 52 cards in half used to play the card game War
  Inputs: option if the user would like to run the program
  Output: Comparison between two cards for the highest value
*/
/**
 * Card lass creates a card object
 * @author Nikki Nguyen, 014682900
 */
public class Card {
    private int suit; //what symbol card is
    private int rank; //what number/face card is
    private boolean faceup; //to show or not to show card
    private int rankV,suitV; //gives an integer for rank and suit
    //set rank and suit in array of strings
    private static final String[] RANKS = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    private static final String[] SUITS = {"Spades","Clubs","Diamonds","Hearts"};
    /**
     * constructor that initializes the values of rank and suit
     */
    public Card(){
        rankV = 0;//value of rank
        suitV = 0;//value of suit
    }
    /**
     * method constructs card,takes in a rank/suit and sets this rank to value, suit to suit, and card is currently faced up
     * @param rank for rank
     * @param suit for suit
     */
    public Card(int rank, int suit) {
        rankV = rank;
        suitV = suit;
        faceup = true;

    }

    /**
     * returns rank of the card as an integer
     * @return rank
     */
    public int getRank(){
        return rankV+1;
    }

    /**
     * returns suit of the card as a string
     * @return suit
     */
    public int getSuit(){
        return suit;
    }

    /**
     * uses the rank of a card to get its value, according to Bicycle ascending order is A K Q J T 9 8 7 6 5 4 3 2
     * @return value of the card
     */
    public int getValue(){
        rankV = rank;
        return rankV ;
    }

    /**
     * if the card is not faced up, then card is face down
     */
    public void faceDown() {
        faceup = false;
    }

    /**
     * card is faced up which is true
     */
    public void faceUp() {
        faceup = true;
    }

    /**
     *
     * @return this card's faceup boolean (t/f)
     */
    public boolean getFaceUp() {
        return faceup;
    }

    /**
     * overrides toString function and prints out rank and suit of the card
     * @return "rank of suit" of card
     */
    @Override
    public String toString(){
        if(!getFaceUp()){
            return("??? of ???");
        }else{
        return (RANKS[rankV] + " of " + SUITS[suitV]);
        }
    }
}
