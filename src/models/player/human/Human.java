package models.player.human;

import models.card.Card;
import models.role.Role;

import java.util.ArrayList;

public class Human extends models.player.Player {
    public Human(String name, int money, ArrayList<Card> hand, Role role) {
        super(name, money, hand, role);
    }
}
