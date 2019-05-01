
public class Player {

    private Card[] hand;
    public int wallet;
    private int count;
    private int value;
    boolean win;

    //initialize hand and values
    public Player() {
        wallet = 10000;//change to 10
        count = 0;
        hand = new Card[52];

    }
//call the calculation of the hands

    void draw(Card C) {
        hand[count] = C;
        count++;
        this.calcValue(C);

        // After you increment the count you would want to update the value
        // based on the card.
    }

    //reset the card back to 0 for new game
    public void emptyHand() {
        for (; count >= 0; count--) {
            hand[count] = null;

        }
        count = 0;
    }

    //calculate the aces and value of cards
    private void calcValue(Card card) {
        int ace = 0;
        int cardNum = card.getValue();
        if (cardNum == 1) {
            ace++;
            this.value += 11;
        } else if (cardNum > 10) {
            this.value += 10;
        } else {
            this.value += cardNum;
        }
        while (this.value > 21 && ace > 0) {
            this.value -= 10;
            ace--;
        }
    }



    //win and lose, add and subtract the bets
    public int win(int bet) {

        return wallet += bet;

    }

    public int lose(int bet) {

        return wallet -= bet;

    }

    //return the wallet to be used in main
    public int getWallet() {
        return wallet;
    }

    //displays the hand
    public void display() {
        for (int i = 0; i < count; i++) {
            hand[i].display();
        }
    }

    //set value to actual variable
    public void setValue(int value) {
        this.value = value;
    }

    //returns value
    public int getValue() {
        return value;
    }

    //flip the dealer's card faceup
    public void displayHand() {
        //first card
        if (!hand[0].getFaceUp()) {
            hand[0].faceUp();
        }
        for (int i = 0; i < count; i++) {
            hand[i].display();
        }
    }
}
