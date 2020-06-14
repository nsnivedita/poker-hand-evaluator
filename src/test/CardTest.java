package test;

import com.inclusivity.Card;
import org.junit.jupiter.api.DynamicTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardTest {

    @org.junit.Test
  public   void testSmoke() {
        new Card("AS");
    }

    @org.junit.Test
   public void testIllegalValue() {
        assertThrows(IllegalArgumentException.class, () -> new Card("Z"));
    }
    @org.junit.Test
  public   void testIllegalSuit() {
        assertThrows(IllegalArgumentException.class, () -> new Card("-z"));
    }

    @org.junit.Test
  public   void testGetValue(){
        assertEquals(14, new Card("AS").getValue());
        assertEquals(13, new Card("KH").getValue());
        assertEquals(2, new Card("2S").getValue());
    }

    @org.junit.Test
    public void testGetSuits(){
        assertEquals('S', new Card("AS").getSuit());
        assertEquals('H', new Card("KH").getSuit());
        assertEquals('D', new Card("3D").getSuit());
    }



}
