/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class LastWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        while (!s.equals("")){
            String[] arr = s.split(" ");

            System.out.println(arr[arr.length-1]);
            s = scanner.nextLine();

        }


    }
}
