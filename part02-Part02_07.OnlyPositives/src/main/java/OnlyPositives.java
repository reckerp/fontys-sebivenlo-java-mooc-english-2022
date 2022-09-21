/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class OnlyPositives {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Give a number:");
            int inp = Integer.valueOf(scanner.nextLine());
            if(inp == 0){
                break;
            } else if (inp > 0){
                System.out.println(Math.pow(inp, 2));
            } else{
                System.out.println("Unsuitable number");
            }
        }

    }
}
