/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Cat extends Animal implements NoiseCapable{

    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super("Cat");
    }

    public void purr() {
        System.out.println(getName() + " purrs");
    }

    @Override
    public void makeNoise() {
         purr();   
    }
    
}
