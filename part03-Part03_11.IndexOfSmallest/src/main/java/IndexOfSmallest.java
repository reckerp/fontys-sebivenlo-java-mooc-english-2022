/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfSmallest {

    public static void main(String[] args) {
        // implement here a program that reads user input
        // until the user enters 9999
        
        // after that, the program prints the smallest number
        // and its index -- the smallest number
        // might appear multiple times
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 9999) {
                break;
            }

            list.add(input);
        }
        int smallest = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < smallest){
                smallest = list.get(i);
                index = i;
            }
        }
        
        System.out.println("Smallest number: "+smallest);
        System.out.println("Found at index: "+index);
    }
}
