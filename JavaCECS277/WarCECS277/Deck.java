/*Nikki Nguyen
  September 21, 2017
  Purpose: This program will split a deck of 52 cards in half used to play the card game War
  Inputs: option if the user would like to run the program
  Output: Comparison between two cards for the highest value
*/
import java.util.ArrayList; //import arraylist function
import java.util.Collections; //import shuffle
/**
 *deck class constructs card objects in a deck arraylist
 * @author NikkiNguyen
 */
public class Deck {

    /**
     * arraylist to make a deck which will holds objects
     */
    private ArrayList<Card> deck;

    /**
     * constructor that initializes the deck arraylist
     */
    public Deck(){
        deck = new ArrayList<Card>();
    }

    /**
     * method add cards to the deck
     */
    public void addCards(){
        //nested for loop, for every suit, there are 13 cards
        deck.clear();
        for(int s = 0; s < 4; s++){
            for(int r = 0; r < 13; r++){
                deck.add(new Card(r,s)); //add card to deck
            }
        }
    }


    /**
     * removes the first card from the deck object from arraylist
     * @return removed object
     */
    public Card deal(){
        Card c = deck.remove(0);
        return c;
    }

    /**
     * gives how many cards are left
     * @return number of cards left in deck
     */
    public int cardsLeft(){
        return deck.size();
    }

    /**
     * calls shuffle method that randomizes cards
     */
    public void shuffle(){
        Collections.shuffle(deck);
    }

    /**
     * returns boolean for remaining cards in deck
     * @return true if there are no cards left in the deck
     */
    public boolean isEmpty(){
        return (deck.isEmpty());
    }

    /**
     * adds a card to the deck
     * @param c
     */
    public void add(Card c){
	deck.add(c);
    }

    /**
     * combines winner's won cards at the bottom of the deck
     * @param deck pile of cards won
     * @return return this deck size
     */
    public int toBottom(Deck deck){
        while(!deck.isEmpty()) //while where are cards in the deck
		{
		this.add(deck.deal()); //add the parameter
		}
        return this.deck.size(); //return the deck size
	}

    /**
     * overrides the toString method
     * @return deck
     */
    @Override
    public String toString(){
        return(deck.toString());
    }
}
