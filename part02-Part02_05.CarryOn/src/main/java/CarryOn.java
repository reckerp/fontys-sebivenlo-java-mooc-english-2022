/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class CarryOn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true){
            System.out.println("Shall we carry on?");
            String inp = scanner.nextLine();
            if(inp.equals("no")){
                break;
            }
        }
    }
}
