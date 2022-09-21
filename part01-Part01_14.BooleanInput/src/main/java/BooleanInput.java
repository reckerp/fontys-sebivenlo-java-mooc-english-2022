/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class BooleanInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your program here
        System.out.println("Write something:");
        String s = scanner.nextLine();
        boolean b = Boolean.parseBoolean(s);
        System.out.println("True or false? "+b);
    }
}
