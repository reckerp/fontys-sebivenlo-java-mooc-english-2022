/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Product {
    
    private String name;
    private double price;
    private int quantity;
    
    
    
    public Product(String initialName, double initialPrice, int initialQuantity){
        name = initialName;
        price = initialPrice;
        quantity = initialQuantity;
    }
    
    public void printProduct(){
        System.out.println(name);
        System.out.println(price);
        System.out.println(quantity);

    }
}
