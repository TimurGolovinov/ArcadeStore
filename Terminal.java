package datenightatthearcade;

import java.util.*;
import java.lang.Exception;

public class Terminal {

    ArrayList<ArrayList<Prize>> prizes = new ArrayList<ArrayList<Prize>>();

    public void addToBalance(Card c, int b) throws Exception {
        if (b < 0) {
            throw new Exception("Amount to add must be greater than 0");
        } else if (c.balance > (Integer.MAX_VALUE - b) - b) {
            throw new Exception("New balance must be <= " + Integer.MAX_VALUE);
        }
        c.balance += 2 * b;
    }

    public void printCardBalance(Card c) {
        System.out.println("Card number: " + c.cardNumber + "\nCredits: " + c.balance);
        System.out.println("Ticket Balance: " + c.ticketBalance);
        System.out.println("");
    }

    public void transferCardCredits(Card source, Card target, int amountToTransfer) throws Exception {
        if (amountToTransfer > source.balance) {
            throw new Exception("Insufficient credit to transfer!");
        }
        if (target.balance > (Integer.MAX_VALUE - amountToTransfer)) {
            throw new Exception("Amount to recieve will overflow recievers balance!");
        }

        source.balance -= amountToTransfer;
        target.balance += amountToTransfer;

        printCardBalance(source);
        printCardBalance(target);
    }

    public void transferCardTickets(Card source, Card target, int amountToTransfer) throws Exception {
        if (amountToTransfer > source.ticketBalance) {
            throw new Exception("Insufficient tickets to transfer!");
        }
        if (target.ticketBalance > (Integer.MAX_VALUE - amountToTransfer)) {
            throw new Exception("Amount to recieve will overflow recievers ticketBalance!");
        }

        source.ticketBalance -= amountToTransfer;
        target.ticketBalance += amountToTransfer;

        printCardBalance(source);
        printCardBalance(target);
    }

    public void displayPrizes() {
        for (int i = 0; i < prizes.size(); i++) {
            if (prizes.get(i).size() > 0) {
                System.out.println(prizes.get(i).get(0).ToString() + "\nNumber of prize(s) :" + prizes.get(i).size());
                System.out.println("");
            }
        }

    }

    public Prize getPrize(String name, Card playerCard) throws Exception {
        for (int i = 0; i < prizes.size(); i++) {
            if (prizes.get(i).size() > 0) {
                if (prizes.get(i).get(0).name == name) {
                    Prize result = prizes.get(i).get(0);
                    if (result.numberOfTicketsRequired > playerCard.ticketBalance) {
                        throw new Exception("Insufficient funds!");
                    }
                    else{
                    prizes.get(i).remove(0);                   
                    playerCard.ticketBalance -= result.numberOfTicketsRequired;
                    System.out.println("Please enjoy your " + result.name + "!");
                    System.out.println("");
                    return result;
                    }
                }
            }
        }
        throw new Exception("No prize found with that name!");
    }



public Terminal() {

        ArrayList<Prize> list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            try {
                list.add(new Prize("teddy", 100));
            } catch (Exception e) {
                return;
            }

        }
        prizes.add(list);

        list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            try {
                list.add(new Prize("baseball", 120));
            } catch (Exception e) {
                return;
            }
        }
        prizes.add(list);

        list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            try {
                list.add(new Prize("cap gun", 120));
            } catch (Exception e) {
                return;
            }
        }
        prizes.add(list);

    }

}
