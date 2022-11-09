
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class Employees {
    private ArrayList<Person> employees = new ArrayList<>();
    
    public void add(Person personToAdd){
        employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd){
        employees.addAll(peopleToAdd);
    }
    
    public void print(){
        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
                System.out.println(iterator.next());
        }    
    }
    
    public void print(Education education){
        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Person nextPerson = iterator.next();
            if (nextPerson.getEducation().equals(education)) {
                    System.out.println(nextPerson);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Person nextPerson = iterator.next();
            if (nextPerson.getEducation().equals(education)) {
                iterator.remove();
            }
        }
    }
}
