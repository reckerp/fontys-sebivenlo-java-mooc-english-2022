
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Hand implements Comparable<Hand>{
    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        Iterator<Card> iterator = hand.iterator();

        while(iterator.hasNext()) {
                Card nextCard = iterator.next();
                System.out.println(nextCard);
        }
    }

    public void sort(){
        Comparator comparator = Comparator
                .comparing(Card::getValue)
                .thenComparing(Card::getSuit);

        Collections.sort(hand, comparator);
    }
    
    @Override
    public int compareTo(Hand handToCompare) {
        int thisHandValue = 0;
        
        thisHandValue = hand.stream().map((card) -> card.getValue()).reduce(thisHandValue, Integer::sum);
        int compareHandValue = 0;
        
        compareHandValue = handToCompare.hand.stream().map((card) -> card.getValue()).reduce(compareHandValue, Integer::sum);
        return thisHandValue - compareHandValue;
    }
    
    public void sortBySuit(){
        Collections.sort(hand, new BySuitInValueOrder());
    }
}
