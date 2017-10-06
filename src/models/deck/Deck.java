package models.deck;

import models.card.Card;
import models.color.Color;

import java.util.ArrayList;

public class Deck {
    final int DECK_SIZE = 52;
    final int NUMBER_OF_COLORS = 4;
    final int CARDS_PER_COLOR = 13;
    private ArrayList<Card> deck;

    public Deck() {
        deck = generateDeck();
    }

    private ArrayList<Card> generateDeck() {
        ArrayList<Card> tempDeck = new ArrayList<>();
        for (int j = 0; j < NUMBER_OF_COLORS; j++) {
            for (int k = 0; k < CARDS_PER_COLOR; k++) {
                Color color = null;
                switch (j) {
                    case 0:
                        color = Color.HEARTS;
                        break;
                    case 1:
                        color = Color.SPADES;
                        break;
                    case 2:
                        color = Color.DIAMONDS;
                        break;
                    case 3:
                        color = Color.CLUBS;
                        break;
                }
                tempDeck.add(new Card(color, k + 2));
            }
        }
        return tempDeck;
    }

    @Override
    public String toString() {
        String out = "";
        for (Card card : this.deck) {
            out += card.toString() + "\n";
        }
        return out;
    }

    public ArrayList<Card> shuffle() {
        ArrayList<Card> shuffleDeck = new ArrayList<>();
        for (int i = 0; i < DECK_SIZE; i++) {
            int randomInt = (int) (Math.random() * this.deck.size());
            shuffleDeck.add(deck.get(randomInt));
            deck.remove(randomInt);
        }
        return shuffleDeck;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.deck = deck.shuffle();
        System.out.println(deck.toString());
    }
}