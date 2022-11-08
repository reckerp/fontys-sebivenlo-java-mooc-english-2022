
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<>();

        while (true) {
            int input = scanner.nextInt();
            if (input < 0) {
                break;
            }
            inputs.add(input);
        }
        
        inputs.stream().filter(num -> num >=1 && num <= 5).forEach(num -> System.out.println(num));
    }
}
