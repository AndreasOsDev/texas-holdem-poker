package models.game;


import models.player.ai.Ai;
import models.player.Player;
import models.player.human.Human;
import models.table.Table;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Game {
    private Table table;
    public Game() {

    }
    public void start() {
        setUpGame();
        table.startGame();
    }

    private void setUpGame() {
        setUpTable();
        ArrayList<Player> players = new ArrayList<>();
        players.add(addHumanPlayer());
        players.addAll(addAiPlayers(4));
        table.setPlayers(players);
    }

    private ArrayList<Player> addAiPlayers(int numberOfAi) {
        ArrayList<Player> ai = new ArrayList<>();
        for (int i = 0; i < numberOfAi; i++) {
            ai.add(new Ai(findRandomName()));
        }
        return ai;
    }

    private String findRandomName() {
        String randomName = null;
        RandomAccessFile f = null;
        long randomLocation = Long.parseLong(null);
        try {
            f = new RandomAccessFile("../../resources/AiNames", "r");
            randomLocation = (long) (Math.random() * f.length());
            f.seek(randomLocation);
            randomName = f.readLine();
        f.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            randomName = "BOB!";
        }
        return randomName;
    }

    private Player addHumanPlayer() {
        Player human = new Human("Steve");
        return human;
    }

    private void setUpTable() {
        table = new Table(20, 40);
        
    }
}
