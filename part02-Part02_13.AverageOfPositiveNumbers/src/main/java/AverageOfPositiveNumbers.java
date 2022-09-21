/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        
        while (true){
            System.out.println("Give a number:");
            int inp = Integer.valueOf(scanner.nextLine());
            if(inp == 0){
                break;
            } else if (inp > 0){
                sum += inp;
                count++;
            }
        }
        
        if(sum == 0){
            System.out.println("Cannot calculate the average");
        } else{
            System.out.println(1.0*sum/count);
        }
        

    }
}
