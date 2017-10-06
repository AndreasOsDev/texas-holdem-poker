package models.card;

import models.color.Color;

public class Card {
    private Color color;
    private int value;
    public Card(Color color, int value){

        this.color = color;

        this.value = value;
    }
    public Color getColor(){
        return color;
    }
    public int getValue(){
        return value;
    }
    @Override
    public String toString(){
        String outputValue = convertValueToString();
        return String.format("%s of %s",outputValue,color.toString().toLowerCase());
    }

    private String convertValueToString() {
        String outputValue;
        switch(this.getValue()){
            case 11: outputValue = "Jack"; break;
            case 12: outputValue = "Queen"; break;
            case 13: outputValue = "King"; break;
            case 14: outputValue = "Ace"; break;
            default: outputValue = this.getValue()+"";
        }
        return outputValue;
    }

    public static void main(String[] args) {
        Card card = new Card(Color.HEARTS,12);
        System.out.println(card.toString());
    }
}



