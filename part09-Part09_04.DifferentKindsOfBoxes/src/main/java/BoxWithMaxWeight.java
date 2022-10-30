
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
public class BoxWithMaxWeight extends Box {
    
    private final int capacity;
    private int weight;
    private ArrayList<Item> items;


    public BoxWithMaxWeight(int capacity) {
        items = new ArrayList<>();
        this.capacity = capacity;
    }
    
    

    @Override
    public void add(Item item) {
        if (weight + item.getWeight() <= capacity) {
            items.add(item);
            weight += item.getWeight();
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
    
}
