
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        List<String> inputs = new ArrayList<>();

        // reading inputs
        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end")) {
                break;
            }

            inputs.add(row);
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String whichAverage = scanner.nextLine();
        
        if (whichAverage.equals("n")) {
            double avg = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(num -> num < 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: "+avg);
        } else if (whichAverage.equals("p")){
            double avg = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(num -> num >= 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: "+avg);
        }
    }
}
