
public class Card {

    private char suit;
    private int rank;
    private boolean faceup = true;
    private int value;

//creates individual cards
    public Card(int r, char s) {
        rank = r;
        suit = s;
        faceup = true;

    }

    public void display() {
        if (!faceup) {
            System.out.println("??? of ???");
        } else{
            //display rank
            if (rank == 1) {
                System.out.print("Ace of ");
            } else if (rank == 2) {
                System.out.print("2 of ");
            } else if (rank == 3) {
                System.out.print("3 of ");
            } else if (rank == 4) {
                System.out.print("4 of ");
            } else if (rank == 5) {
                System.out.print("5 of ");
            } else if (rank == 6) {
                System.out.print("6 of ");
            } else if (rank == 7) {
                System.out.print("7 of ");
            } else if (rank == 8) {
                System.out.print("8 of ");
            } else if (rank == 9) {
                System.out.print("9 of ");
            } else if (rank == 10) {
                System.out.print("10 of ");
            } else if (rank == 11) {
                System.out.print("Jack of ");
            } else if (rank == 12) {
                System.out.print("Queen of ");
            } else if (rank == 13) {
                System.out.print("King of ");
            }

            //display suit
            if (suit == 'S') {
                System.out.println("Spades");
            } else if (suit == 'C') {
                System.out.println("Clubs");
            } else if (suit == 'D') {
                System.out.println("Diamonds");
            } else if (suit == 'H') {
                System.out.println("Hearts");
            }

        }
    }

    //return value of aces. face cards, and else
    public int getValue() {

        if (rank < 10) {
            value = rank;
        } else if (rank >= 10) {
            value = 10;
        } else if (rank == 1) {
            value = 11;
        } else {
            value = rank;
        }

        return value;
    }

    //set boolean to true or false then return
    public void faceDown() {
        faceup = false;

    }

    public void faceUp() {
        faceup = true;


    }

    public boolean getFaceUp() {
        return this.faceup;
    }



}
