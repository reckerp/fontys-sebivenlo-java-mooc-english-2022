/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class MessageThreeTimes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a message:");
        // Write your program here
        String m = scanner.nextLine();
        System.out.println(m);
        System.out.println(m);
        System.out.println(m);

    }
}
