/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class OnTheList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            list.add(input);
        }
        
        System.out.println("Search for? ");
        String s = scanner.nextLine();
        String n = "";
        for(String name : list){
            if (name.equals(s)) {
                n = name;
            }
        }
        
        if (n.equals(s)) {
            System.out.println(s+" was found!");
        } else {
            System.out.println(s+" was not found!");
        }

    }
}
