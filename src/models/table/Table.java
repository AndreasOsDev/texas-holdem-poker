package models.table;

import models.card.Card;
import models.deck.Deck;
import models.player.Player;
import models.role.Role;

import java.util.ArrayList;

public class Table {
    private int minBid;
    private int maxBid;
    private ArrayList<Player> players;
    private int pot;
    private Deck deck;
    private final int MAX_CARDS = 2;

    public Table(int minBid, int maxBid) {
        this.minBid = minBid;
        this.maxBid = maxBid;
        deck = new Deck();
        pot = 0;
        players = new ArrayList<>();
    }

    public void startGame() {
        deck = new Deck();
        System.out.println("Deck created");
        dealCards();
        System.out.println("Cards dealt");
        assignRoles();
        System.out.println("Roles are hella assigned");
        for (Player player : players) {
            System.out.println(player.toString());
        }
    }

    public void assignRoles() {
        for (int i = 0; i < players.size(); i++) {
            switch (i) {
                case 0:
                    players.get(i).setRole(Role.BIGBLIND);
                    break;
                case 1:
                    players.get(i).setRole(Role.SMALLBLIND);
                    break;
                default:
                    players.get(i).setRole(Role.PLAYER);
                    break;
            }
        }
    }

    public void dealCards() {
        for (Player player : players) {
            ArrayList<Card> tempHand = new ArrayList<>();
            for (int i = 0; i < MAX_CARDS; i++) {
                tempHand.add(deck.getDeck().remove(0));
            }
            player.setHand(tempHand);
        }
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
