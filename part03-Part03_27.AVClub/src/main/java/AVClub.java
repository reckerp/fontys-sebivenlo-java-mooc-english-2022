/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class AVClub {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        while (!s.equals("")){
            String[] arr = s.split(" ");

            for(String str: arr){
                if (str.contains("av")) {
                    System.out.println(str);
                }
            }
            s = scanner.nextLine();

        }


    }
}
