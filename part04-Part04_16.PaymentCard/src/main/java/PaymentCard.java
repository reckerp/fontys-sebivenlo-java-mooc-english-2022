/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class PaymentCard {
    private double balance;

    public PaymentCard(double openingBalance) {
        this.balance = openingBalance;
    }
    
    public void eatAffordably(){
        if (balance - 2.60 >= 0) {
           balance -= 2.60; 
        }
        
    }
    public void eatHeartily(){
        if (balance - 4.60 >= 0) {
           balance -= 4.60; 
        }
    }
    public void addMoney(double amount){
        double total;
        double overage;
        if (amount > 0) {
            total = this.balance + amount;
            overage = total - 150;
            if (total > 150.00) {
                total -= overage;
            }
            this.balance = total;
        }
        
    }
    public String toString(){
       return "The card has a balance of "+balance+" euros";
    }
    
    
    
}
