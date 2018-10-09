
package datenightatthearcade;

public class Prize {
    protected String name;
    int numberOfTicketsRequired;
    
    public String ToString(){
        return ("Name: " + name + "\nTicket cost: " + numberOfTicketsRequired); 
    }
    
    public Prize(String prizeName, int numberOfTicketsRequired) throws Exception{
        if(numberOfTicketsRequired <= 0){
            throw new Exception("Prizes must cost atleast 1 ticket");
        }
        
        this.name = prizeName;
        this.numberOfTicketsRequired = numberOfTicketsRequired;
    }
    
}
