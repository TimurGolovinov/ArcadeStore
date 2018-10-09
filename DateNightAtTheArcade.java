package datenightatthearcade;

import java.util.ArrayList;
import java.util.Scanner;

public class DateNightAtTheArcade {



    public static void main(String[] args) {

        Game[] games = new Game[5];
        Terminal t1 = new Terminal();
        Terminal t2 = new Terminal();
        Card c1, c2;
        
        
        
        try {
            c1 = new Card();
            c2 = new Card();
            for (int i = 0; i < 5; i++) {
                games[i] = new Game(i + 1, 5 + i * 50, 2 + i);
            }
            
            t1.addToBalance(c1, 500);
            t2.addToBalance(c2, 1000);

            
            games[1].play(c2);
            games[2].play(c2);
            games[3].play(c1);
            games[4].play(c1);
            games[0].play(c1);
     
            
            
            t1.printCardBalance(c1);
            t2.printCardBalance(c2);
            
            t1.transferCardCredits(c1, c2, c1.balance);
            t1.transferCardTickets(c1, c2, c1.ticketBalance);
            
            t1.printCardBalance(c1);
            t1.printCardBalance(c2);
            System.out.println("");
           
            t1.displayPrizes();
            t1.getPrize("teddy", c2);
            
            t1.displayPrizes();            
            
            games[0].play(c1);
            
            
            
        } catch (Exception e) {
            //this wont actually happen
            System.out.println(e.getMessage());
            return;
        }

    }

}
