/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class DivisibleByThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        divisibleByThreeInRange(3, 6);

    }
    
    public static void divisibleByThreeInRange(int b, int e){
        for (int i = b; i <= e; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }

}
