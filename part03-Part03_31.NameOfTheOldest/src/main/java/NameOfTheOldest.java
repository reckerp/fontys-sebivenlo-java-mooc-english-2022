/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class NameOfTheOldest {

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
        String name = "";
        for(String[] person: allPeople){
            if(Integer.valueOf(person[1]) > oldest){
                oldest = Integer.valueOf(person[1]);
                name = person[0];
            }
        }
        
        System.out.println("Name of the oldest: "+name);


    }
}
