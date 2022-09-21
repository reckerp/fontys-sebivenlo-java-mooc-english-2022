/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Book {
    private String name;
    private int pages;
    private int puby;

    public Book(String name, int pages, int puby) {
        this.name = name;
        this.pages = pages;
        this.puby = puby;
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }

    public int getPuby() {
        return puby;
    }

    @Override
    public String toString() {
        return name + ", " + pages + " pages, " + puby + '}';
    }
    
    
}
