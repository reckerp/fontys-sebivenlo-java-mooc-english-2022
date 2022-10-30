import java.util.List;
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
public class Herd implements Movable{
    private List<Movable> herd;

    public Herd() {
        herd = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        herd.add(movable);
    }


    @Override
    public void move(int dx, int dy) {
        for (Movable movable : herd) {
            movable.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String herdString = "";
        for (Movable movable : herd) {
            herdString += movable.toString() + "\n";
        }
        return herdString;
    }
    
}
