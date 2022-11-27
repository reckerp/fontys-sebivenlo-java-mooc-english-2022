/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Hideout<T> {
    private T hideout;

    public void putIntoHideout(T toHide) {
        hideout = toHide;    
    }

    public T takeFromHideout() {
        T temp = hideout;
        hideout = null;
        return temp;
    }

    public boolean isInHideout() {
        return hideout != null;
    }
}
