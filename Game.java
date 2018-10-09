
package datenightatthearcade;
import java.util.Random;;

public class Game {
    private int playingPrice;
    private int maxPayout;
    private int minPayout;
    Random rnd = new Random();
    
    public Game(int playingPrice, int maxPayout, int minPayout)throws Exception{
        if(playingPrice <= 0)
            throw new Exception("Playing price must be greater than 0");
        if(maxPayout < minPayout)
            throw new Exception("maxPayout must be atleast minPayout");
        if(maxPayout <= 0)
            throw new Exception("maxPayout must be greater than 0");
        
        if(minPayout < 0)
            throw new Exception("minPayout must be atleast 0");
        
        this.playingPrice = playingPrice;
        this.maxPayout = maxPayout;
        this.minPayout = minPayout;
        
        
    }
    
    public void play(Card playerCard)throws Exception{
        if(playerCard.balance < playingPrice){
            throw new Exception("Card must have sufficient funds");
        }
        if(playerCard.ticketBalance > Integer.MAX_VALUE - maxPayout){
            throw new Exception("maxPayout could overflow ticket balance!");
        }
        
        playerCard.balance -=  playingPrice;
        int possibleWinsCounts = ((maxPayout - minPayout) + 1 );
        playerCard.ticketBalance += rnd.nextInt(possibleWinsCounts )+ minPayout;        
        
            
    }
    
}
