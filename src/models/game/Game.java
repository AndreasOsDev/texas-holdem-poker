package models.game;


import models.player.ai.Ai;
import models.player.Player;
import models.player.human.Human;
import models.table.Table;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Game {
    private Table table;
    public Game() {

    }
    public void start() {
        System.out.println("setting up game");
        setUpGame();
        System.out.println("Setup finished");
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

        try {
            RandomAccessFile f = new RandomAccessFile("src\\resources\\AiNames", "r");
            final long randomLocation = (long) (Math.random() * f.length());
            f.seek(randomLocation);
            f.readLine();
            randomName = f.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
