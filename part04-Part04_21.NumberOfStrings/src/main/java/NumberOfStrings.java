/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class NumberOfStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            String s = scanner.nextLine();
            if(s.equals("end")){
                break;
            }
            count++;
        }
        System.out.println(count);
        
    }
}
