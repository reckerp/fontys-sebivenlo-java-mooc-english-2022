
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class SecondPlusThird {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == 0) {
                break;
            }
            
            numbers.add(number);
        }

        System.out.println(numbers.get(1)+numbers.get(2));
    }
}
