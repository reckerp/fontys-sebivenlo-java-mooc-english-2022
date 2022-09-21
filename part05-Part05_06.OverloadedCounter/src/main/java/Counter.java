/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Counter {
    private int count;
    
    public Counter(int startValue){
        count = startValue;
    }
    public Counter(){
        count = 0;
    }

    public int value() {
        return count;
    }
    
    public void increase(){
        count++;
    }
    
    public void decrease(){
        count--;
    }

    public void increase(int increaseBy){
        if (increaseBy > 0){
            count += increaseBy;
        }
    }

    public void decrease(int decreaseBy){
        if (decreaseBy > 0){
            count -= decreaseBy;
        }
    }
    
}
