package com.inclusivity;

/**
        * Poker Hand Evaluator Game
        * This class represents a 52 playing cards.
        * june 14, 2020
        * @author Nivedita Singh
        */

public class Card implements Comparable<Card>{

    private int value;
    private char suit;
    //Values
    private final String values = "23456789TJQKA";
    //Suit
    private final String suits = "CDHS";

    public Card(String str){
        this.setSuit(str.charAt(str.length()-1));
        this.setValue(str.substring(0,str.length()-1));
    }
    public int getValue(){
        return value;
    }

    public char getSuit(){
        return suit;
    }
    /** sets int value for char */
    public void setValue(String str)
    {
        switch(str){
            case "A" : this.value = 14;
                break;
            case "T" : this.value = 10;
                break;
            case "J" : this.value = 11;
                break;
            case "Q" : this.value = 12;
                break;
            case "K" : this.value = 13;
                break;
            default: this.value = Integer.parseInt(str);
        }
    }

    public void setSuit(char str)
    {
        this.suit = str;
    }

    @Override
    public int compareTo(Card anotherCard) {
        if (this.getValue()<anotherCard.getValue()) return -1;
        else if (this.getValue()>anotherCard.getValue()) return 1;
        else return 0;
    }

    @Override
    public boolean equals(Object o){
        Card anotherCard = (Card) o;
        return this.getValue() == anotherCard.getValue();
    }

    @Override
    public int hashCode(){
        assert false: "no hashcode implementation";
        return 17;
    }

    @Override
    public String toString(){
        return "["+value+suit+"]";
    }
}
