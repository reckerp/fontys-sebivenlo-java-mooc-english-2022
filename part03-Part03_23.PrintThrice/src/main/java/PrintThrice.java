/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class PrintThrice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a word: ");
        String s = scanner.nextLine();
        // Write your program here
        for (int i = 0; i < 3; i++) {
            System.out.print(s);
        }

    }
}
