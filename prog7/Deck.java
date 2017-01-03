/*
 Jeffrey Stewart
 03/26/2015
 Program 7
 BlackJack
 */
package prog7;

public class Deck {

    private Card[] deck = new Card[52];
    private int nextCard = 0;

    //Constructor
    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[nextCard] = new Card(i, j);
                nextCard++;
            }
        }
        nextCard = 0;
    }

    //Shuffles by replacing a random number after the index with the index
    //for each index of the deck
    public void shuffle() {
        for (int k = 0; k < 52; k++) {
            int random = (int) ((Math.random() * (50 - k)) + 1 + k);
            Card store = deck[random];
            deck[random] = deck[k];
            deck[k] = store;
        }
        nextCard = 0;
    }

    public Card dealCard() {
        Card newCard = deck[nextCard];
        nextCard++;
        return newCard;
    }

    public int getCardsRemaining() {
        return (52 - nextCard);
    }

    @Override
    public String toString() {
        String display = "";
        for (int w = 0; w < 52; w++) {
            display += deck[w].toString() + " ";
        }
        return display;
    }

}
