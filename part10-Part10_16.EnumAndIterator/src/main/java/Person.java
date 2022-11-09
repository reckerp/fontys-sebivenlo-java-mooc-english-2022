/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Person {
    private String name;
    private Education education;

    public Person(String name, Education education) {
        this.name = name;
        this.education = education;
    }
    
    public Education getEducation(){
        return education;
    }

    @Override
    public String toString() {
        return name + ", "+education;
    }
    
    
}
