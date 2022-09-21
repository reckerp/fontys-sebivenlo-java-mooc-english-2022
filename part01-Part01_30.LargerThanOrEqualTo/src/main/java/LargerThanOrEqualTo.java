/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class LargerThanOrEqualTo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here
        System.out.println("Give the first number: ");
        int number1 = scan.nextInt();
        System.out.println("Give the second number: ");
        int number2 = scan.nextInt();

        if (number1 > number2){
            System.out.println("The greater number is " + number1);
        } else if (number1 == number2){
            System.out.println("The numbers are equal.");
        } else {
            System.out.println("The greater number is " + number2);
        }
    }
}
