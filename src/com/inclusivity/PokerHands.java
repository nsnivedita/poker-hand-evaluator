package com.inclusivity;

import java.io.*;

public class PokerHands {

    public static void main(String[] args) throws IOException{

        String input = null;
        BufferedReader br;
        System.out.println("Enter String of Poker Card Hand(Eg: AS,JC,TH,3D,3S):");

        while(input == null)
        {
            br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine().trim();
            if(input.isEmpty() || input.isEmpty())
            {
                System.out.println("ERROR: Input cannot be empty !! \nPlease try again...\n");
                input=null;
            }
            else if (input.length() < 14)
            {
                System.out.println("ERROR: Input should have 5 cards in comma separated !! \nPlease try again...\n");
                input=null;
            }
        }
        Hand hand = new Hand(input);
        System.out.println("Best Hand Rank is : " + hand.evaluate());
    }
}
