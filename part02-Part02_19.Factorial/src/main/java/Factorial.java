/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a number: ");
        int num = Integer.valueOf(scanner.nextLine());
        int fact = 1;
        
        
        for (int i = 1; i <= num; i++) {
            fact*=i;
        }
        System.out.println("Factorial: "+fact);
    }
}
