/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Gauge {
    private int value;

    public Gauge() {
       
    }
    
    public void increase(){
        if (value !=5) {
            value++;
        }
        
    }
    
    public void decrease(){
        if(value != 0){
            value--;
        }
        
    }
    
    public boolean full(){
        if (value == 5) {
            return true;
        }
        return false;
    }

    public int value() {
        return value;
    }

    
    
    
}
