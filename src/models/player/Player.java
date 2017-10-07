package models.player;

import models.card.Card;
import models.deck.Deck;
import models.role.Role;

import java.util.ArrayList;

public class Player {
    String name;
    int money;
    ArrayList<Card> hand;
    Role role;

    public Player(String name, int money, ArrayList<Card> hand, Role role) {
        this.name = name;
        this.money = money;
        this.hand = hand;
        this.role = role;
    }

    @Override
    public String toString() {
        String out;
        out = String.format("%s has %d dollars and %s cards and %s role", getName(), getMoney(), getHand(), getRole());
        return out;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.getDeck().remove(0));
        }
        Player player = new Player("Andreas", 4000, hand, Role.PLAYER);
        System.out.println(player.printHand());
        //System.out.println(player.toString());
    }

    public String printName() {
        return getName();
    }

    public String printMoney() {
        return getMoney() + "";
    }

    public String printHand() {
        StringBuilder out = new StringBuilder();
        for (Card card : this.getHand()) {
            out.append(card.toString() + ", ");
        }
        return out.toString();
    }

    public String printRole() {
        return getRole().toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public Role getRole() {
        return role;
    }
}
