package test;

import com.inclusivity.Card;
import com.inclusivity.Hand;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandTest {

    @org.junit.Test
   public void testEvaluateIsPair() {
        Hand hand = new Hand("AS,2D,2H,5S,6C");
        assertEquals(Hand.handRank.ONEPAIR,hand.evaluate());

    }
    @org.junit.Test
    public void testEvaluateIsTwoPair() {
        Hand hand = new Hand("5S,5D,2H,2S,6C");
        assertEquals(Hand.handRank.TWOPAIR,hand.evaluate());
    }
    @org.junit.Test
    public void testEvaluateIsFourOfAKind() {
        Hand hand = new Hand("2S,2D,2H,2C,2H");
        assertEquals(Hand.handRank.FOUROFAKIND,hand.evaluate());
    }
    @org.junit.Test
    public void testEvaluateIsThreeOfAKind() {
        Hand hand = new Hand("2S,2D,2H,5S,6C");
        assertEquals(Hand.handRank.THREEOFAKIND,hand.evaluate());
    }
    @org.junit.Test
    public void testEvaluateIsStraight() {
        Hand hand = new Hand("10S,9D,8H,7S,6C");
        assertEquals(Hand.handRank.STRAIGHT,hand.evaluate());
    }
    @org.junit.Test
    public void testEvaluateIsFlush() {
        Hand hand = new Hand("10S,8S,6S,5S,3S");
        assertEquals(Hand.handRank.FLUSH,hand.evaluate());
    }
    @org.junit.Test
    public void testEvaluateIsFullHouse() {
        Hand hand = new Hand("6S,6D,6H,KC,KS");
        assertEquals(Hand.handRank.FULLHOUSE,hand.evaluate());
    }
    @org.junit.Test
    public void testEvaluateIsStraightFlush() {
        Hand hand = new Hand("10D,9D,8D,7D,6D");
        assertEquals(Hand.handRank.STRAIGHTFLUSH,hand.evaluate());
    }
    @org.junit.Test
    public void testEvaluateIsHighCard() {
        Hand hand = new Hand("KD,QD,7H,4H,3C");
        assertEquals(Hand.handRank.HIGHCARD,hand.evaluate());
    }
}