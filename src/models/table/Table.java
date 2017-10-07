package models.table;

import models.player.Player;

import java.util.ArrayList;

public class Table {
    private int minBid;
    private int maxBid;
    private ArrayList<Player> players;
    private int pot;

    public Table(int minBid, int maxBid) {
        this.minBid = minBid;
        this.maxBid = maxBid;

    }
}
