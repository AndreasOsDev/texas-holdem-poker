package models.player.ai;

import models.card.Card;
import models.role.Role;

import java.util.ArrayList;

public class Ai extends models.player.Player {

    public Ai(String name, int money, ArrayList<Card> hand, Role role) {
        super(name, money, hand, role);
    }
}
