/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class NumberOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true){
            System.out.println("Give a number:");
            int inp = Integer.valueOf(scanner.nextLine());
            if(inp == 0){
                break;
            } else{
                count++;
            }
        }
        System.out.println("Number of numbers: "+count);


    }
}
