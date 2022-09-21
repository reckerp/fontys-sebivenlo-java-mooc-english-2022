/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class IntegerInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your program here
        System.out.println("Give a number:");
        String s = scanner.nextLine();
        int i = Integer.parseInt(s);
        System.out.println("You gave the number "+i);

    }
}
