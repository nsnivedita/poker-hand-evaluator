package com.inclusivity;

import java.util.Arrays;

public class Hand {

    public static enum handRank{
        HIGHCARD, ONEPAIR, TWOPAIR, THREEOFAKIND, STRAIGHT, FLUSH,
        FULLHOUSE, FOUROFAKIND, STRAIGHTFLUSH
    }

    private Card[] hand;

    public Hand(String handString){
        String[] cards = handString.split(",");
        hand = new Card[cards.length];
        for (int i=0;i<hand.length;i++){
            hand[i] = new Card(cards[i]);
        }
        Arrays.sort(hand);
    }

    public Card[] getHand(){
        return this.hand;
    }

    /**
     * This method sees if the hand contains exactly one pair
     */
    private static boolean isPair(Card[] hand){
        int card1 = hand[0].getValue();
        int card2 = hand[1].getValue();
        int card3 = hand[2].getValue();
        int card4 = hand[3].getValue();
        int card5 = hand[4].getValue();

        return ((card1 == card2 && card2 != card3) ||
                (card2 == card3 && card3 != card4 && card2 != card1) ||
                (card3 == card4 && card4 != card5 && card3 != card2) ||
                (card4 == card5 && card4 != card3));
    }
    /**
     * This method sees if the hand contains exactly two pair
     */
    private static boolean isTwoPair(Card[] hand){
        int card1 = hand[0].getValue();
        int card2 = hand[1].getValue();
        int card3 = hand[2].getValue();
        int card4 = hand[3].getValue();
        int card5 = hand[4].getValue();

        return ((card1 == card2 && card3 == card4 && card2!=card3 && card4 != card5) ||
                (card1 != card2 && card2 == card3 && card3 != card4 && card4 == card5)
        );
    }
    /**
     * This method sees if the hand has exactly three cards with the same value
     * */
    private static boolean isThreeOfAKind(Card[] hand){
        int card1 = hand[0].getValue();
        int card2 = hand[1].getValue();
        int card3 = hand[2].getValue();
        int card4 = hand[3].getValue();
        int card5 = hand[4].getValue();
        return (card1 == card3 || card2 == card4 || card3 == card5);
    }

    /**
     * This method sees if the values are in sequence
     * */

    private static boolean isStraight(Card[] hand){
        int count = 0;
        for(int i = hand.length-1; i > 0 ; i--)
        {
            if((hand[i].getValue() - hand[i-1].getValue())==1)
            {
                count ++;
            }
        }
        return count == 4;
    }

    /**
     * This method sees if the cards in the hand have the same suit and the values
     * 10, 11, 12, 13, 14
     * */
    private static boolean isFlush(Card[] hand){

        for (int i=0;i<hand.length-1;i++){
            if (hand[i+1].getSuit() != hand[i].getSuit()) return false;
        }

        return true;
    }

    /**
     * This method sees if the hand contains three cards with the same value and two
     * other cards with the same value
     * */
    private static boolean isFullHouse(Card[] hand){
        int card1 = hand[0].getValue();
        int card2 = hand[1].getValue();
        int card3 = hand[2].getValue();
        int card4 = hand[3].getValue();
        int card5 = hand[4].getValue();

        return ((card1 == card2 && card2 != card3 && card3 == card5) ||
                (card1 == card3 && card3 != card4 && card4 == card5));
    }
    /**
     * This method sees if the hand has four cards with the same value
     * */
    private static boolean isFourOfAKind(Card[] hand){

        return (hand[0].getValue() == hand[4].getValue());
    }

    /**
     * This method sees if the cards are same suit and in sequence
     * */
    private static boolean isStraightFlush(Card[] hand){

        return isStraight(hand) && isFlush(hand);
    }

    public handRank evaluate()
    {
        Card[] tempHand = this.getHand();
        if (isStraightFlush(tempHand)) return handRank.STRAIGHTFLUSH;
        else if (isFourOfAKind(tempHand)) return handRank.FOUROFAKIND;
        else if (isFullHouse(tempHand)) return handRank.FULLHOUSE;
        else if (isFlush(tempHand)) return handRank.FLUSH;
        else if (isStraight(tempHand)) return handRank.STRAIGHT;
        else if (isThreeOfAKind(tempHand)) return handRank.THREEOFAKIND;
        else if (isTwoPair(tempHand)) return handRank.TWOPAIR;
        else if (isPair(tempHand)) return handRank.ONEPAIR;
        else return handRank.HIGHCARD;
    }

}
