/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String user = scanner.nextLine();
        
        System.out.println("Enter password: ");
        String pass = scanner.nextLine();

        
        if (user.equals("alex") && pass.equals("sunshine") || user.equals("emma") && pass.equals("haskell")) {
            System.out.println("You have successfully logged in!");
        } else{
            System.out.println("Incorrect username or password!");
        }
    }
}
