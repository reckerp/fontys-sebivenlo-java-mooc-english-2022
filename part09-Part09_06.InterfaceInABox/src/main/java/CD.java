/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class CD implements Packable{
    private String artist;
    private String title;
    private int year;
    private double weight;

    public CD(String artist, String title, int year) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        weight = 0.1;
    }
    
    
   @Override
    public String toString() {
        return artist+": "+title+" ("+year+")";
    } 
    
    @Override
    public double weight() {
        return weight;
    }
    
}
