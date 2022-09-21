/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Items {

    public static void main(String[] args) {
        // implement here your program that uses the class Item

        ArrayList<Item> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String name = "x";
        
        while (!name.equals("")) {
            System.out.println("Name: ");
            name = scanner.nextLine();
            items.add(new Item(name));
        }
        
        for (Item item : items) {
            System.out.println(item);
        }

    }
}
