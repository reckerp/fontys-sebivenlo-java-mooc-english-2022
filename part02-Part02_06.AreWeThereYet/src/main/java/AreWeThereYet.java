/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class AreWeThereYet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Give a number:");
            int inp = Integer.valueOf(scanner.nextLine());
            if(inp == 4){
                break;
            }
        }
    }
}
