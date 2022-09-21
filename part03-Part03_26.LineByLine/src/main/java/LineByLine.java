/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class LineByLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        while (!s.equals("")){
            String[] arr = s.split(" ");

            for(String str: arr){
                System.out.println(str);
            }
            s = scanner.nextLine();

        }
        


    }
}
