/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here
        System.out.println("Give a year: ");
        int year = scan.nextInt();
        if (year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0){
                    System.out.println("The year is a leap year.");
                } else {
                    System.out.println("The year is not a leap year.");
                }
            } else {
                System.out.println("The year is a leap year.");
            }
        } else {
            System.out.println("The year is not a leap year.");
        }
    }
}
