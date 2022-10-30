
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Box implements Packable{
    private ArrayList<Packable> packables;
    private final double capacity;

    public Box(double capacity) {
        this.capacity = capacity;
        packables = new ArrayList<>();
    }
    
    public void add(Packable packable){
        if(weight() + packable.weight() <= capacity){
            packables.add(packable);
        }
    }
    
    @Override
    public double weight(){
        
        if (packables.isEmpty()) {
            return 0;
        }
        double weight = 0;
        for (Packable packable : packables) {
            weight += packable.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + packables.size() + " items, total weight " + weight() + " kg";
    }
    
    
}
