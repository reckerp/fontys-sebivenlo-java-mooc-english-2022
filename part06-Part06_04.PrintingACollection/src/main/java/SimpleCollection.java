/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }
    
    public String toString() {
        String output = "";
        if (this.elements.isEmpty()) {
            return "The collection " + this.name + " is empty.";
        } else {
            if (this.elements.size() == 1) {
                output = "The collection " + this.name + " has " + this.elements.size() + " element:";
            } else {
                output = "The collection " + this.name + " has " + this.elements.size() + " elements:";
            }
            for (String element : this.elements) {
                output += "\n" + element; ;
            }
            return output;
        }
        
    }

}
