/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> allPeople = new ArrayList<>();
        
        String s = scanner.nextLine();

        while (!s.equals("")){
            String[] arr = s.split(",");
            allPeople.add(arr);
            s = scanner.nextLine();
        }
        int oldest = 0;
        
        for(String[] person: allPeople){
            if(Integer.valueOf(person[1]) > oldest){
                oldest = Integer.valueOf(person[1]);
            }
        }
        
        System.out.println("Age of the oldest: "+oldest);

    }
}
