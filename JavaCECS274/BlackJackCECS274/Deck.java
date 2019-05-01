import java.util.Random;

public class Deck {

    private int count;
    private Card[] storage;

    //initiate placement for each card
    public Deck() {
        count = 52;
        storage = new Card[52];
        storage[0] = new Card(1, 'S');
        storage[1] = new Card(2, 'S');
        storage[2] = new Card(3, 'S');
        storage[3] = new Card(4, 'S');
        storage[4] = new Card(5, 'S');
        storage[5] = new Card(6, 'S');
        storage[6] = new Card(7, 'S');
        storage[7] = new Card(8, 'S');
        storage[8] = new Card(9, 'S');
        storage[9] = new Card(10, 'S');
        storage[10] = new Card(11, 'S');
        storage[11] = new Card(12, 'S');
        storage[12] = new Card(13, 'S');
        storage[13] = new Card(1, 'C');
        storage[14] = new Card(2, 'C');
        storage[15] = new Card(3, 'C');
        storage[16] = new Card(4, 'C');
        storage[17] = new Card(5, 'C');
        storage[18] = new Card(6, 'C');
        storage[19] = new Card(7, 'C');
        storage[20] = new Card(8, 'C');
        storage[21] = new Card(9, 'C');
        storage[22] = new Card(10, 'C');
        storage[23] = new Card(11, 'C');
        storage[24] = new Card(12, 'C');
        storage[25] = new Card(13, 'C');
        storage[26] = new Card(1, 'D');
        storage[27] = new Card(2, 'D');
        storage[28] = new Card(3, 'D');
        storage[29] = new Card(4, 'D');
        storage[30] = new Card(5, 'D');
        storage[31] = new Card(6, 'D');
        storage[32] = new Card(7, 'D');
        storage[33] = new Card(8, 'D');
        storage[34] = new Card(9, 'D');
        storage[35] = new Card(10, 'D');
        storage[36] = new Card(11, 'D');
        storage[37] = new Card(12, 'D');
        storage[38] = new Card(13, 'D');
        storage[39] = new Card(1, 'H');
        storage[40] = new Card(2, 'H');
        storage[41] = new Card(3, 'H');
        storage[42] = new Card(4, 'H');
        storage[43] = new Card(5, 'H');
        storage[44] = new Card(6, 'H');
        storage[45] = new Card(7, 'H');
        storage[46] = new Card(8, 'H');
        storage[47] = new Card(9, 'H');
        storage[48] = new Card(10, 'H');
        storage[49] = new Card(11, 'H');
        storage[50] = new Card(12, 'H');
        storage[51] = new Card(13, 'H');


    }

    //display the deck
    public void display() {
        for (int i = 0; i < count; i++) {
            storage[i].display();
        }
    }
    //shuffle the deck
    public void shuffle() {
        Random randCard = new Random();
        for (int i = 0; i < 52; i++) {
            int placeHolder = randCard.nextInt(i + 1);
            Card c1 = storage[placeHolder];
            storage[placeHolder] = storage[i];
            storage[i] = c1;

        }
        System.out.println("");
        System.out.println("Shuffling...");
        System.out.println("");
    }

    //deals a card
    public Card deal() {
        return storage[--count];

    }
    //counts how many cards are left in the deck
    public int cardsLeft() {

        return count;
    }

}
