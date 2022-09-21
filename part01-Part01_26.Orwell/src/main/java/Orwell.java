/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class Orwell {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Give a number:");
        int i = scanner.nextInt();
        if(i == 1984){
            System.out.println("Orwell");
        }
    }
}
