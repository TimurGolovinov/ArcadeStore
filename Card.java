
package datenightatthearcade;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Card {
    protected int balance;
    int cardNumber;
    int ticketBalance;
    static Random rnd = new Random();
    static Set<Integer> existingCardsNums = new HashSet<>();
    
    static boolean cardExists(int cardNumber) {
        return existingCardsNums.contains(cardNumber);       
    }
            
    private void InitializeCard(int cardNumber){
        balance = 0;
        this.cardNumber = cardNumber;
        ticketBalance = 0;
        existingCardsNums.add(cardNumber);
    }
    
    public Card()throws Exception{

        if(existingCardsNums.size() == 1 + (long)Integer.MAX_VALUE)
        {
            throw new Exception("All card numbers have been used!");
        }
        //this isn't the best way to this as if all card numbers but a few are in use then its going to loop for a long time!
        cardNumber = rnd.nextInt();
        while(cardExists(cardNumber)){
            cardNumber =  rnd.nextInt();
        }
        InitializeCard(cardNumber);
    }
    
    public Card(int u) throws Exception{
        if(cardExists(u))
            throw new Exception("card number already in use");
        InitializeCard(cardNumber);
    }
    

}
