/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Film {
    
    private String filmName;
    private int filmAgeRating;
    
    public Film(String filmName, int filmAgeRating){
        this.filmName = filmName;
        this.filmAgeRating = filmAgeRating;
    }
    
    public String name(){
        return filmName;
    }
    
    public int ageRating(){
        return filmAgeRating;
    }
}
