package com.company;

/**
 * Created by albertso on 4/7/17.
 */
public class RPC {
    public static String rps(String p1, String p2) {
        // assign p1 to int values. rock = 0 paper 1 scissors 2
        int p1int = -50;
        int p2int = -99;
        if (p1 == "rock") {
            p1int = 0;
        } else if (p1 == "paper") {
            p1int = 1;
        } else { // scissors
            p1int = 2;
        }
        if (p2 == "rock") {
            p2int = 0;
        } else if (p2 == "paper") {
            p2int = 1;
        } else { // scissors
            p2int = 2;
        }
        // if p1 == p2, return 'tie'
        if (p1 == p2) {
            return "Draw!";
        } else if (p1int == p2int+1 || p1int+2 == p2int) {
            return "Player 1 won!";
        } else if (p2int == p1int+1 || p2int+2 == p1int) {
            return "Player 2 won!";
        } else {
            return "int values weren't assigned";
        }
        // if p1 > p2 by only 1 or , return 'p1 won'
        // otherwise return p2
    }
}