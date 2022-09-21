/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class DifferentTypesOfInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Give a string:");
        String s = scanner.nextLine();
        
        System.out.println("Give an integer:");
        int i = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Give a double:");
        double d = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Give a boolean:");
        boolean b = Boolean.parseBoolean(scanner.nextLine());
        
        System.out.println("You gave the string " + s);
        System.out.println("You gave the integer "+ i);
        System.out.println("You gave the double "+ d);
        System.out.println("You gave the boolean "+ b);

    }
}
