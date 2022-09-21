/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> allPeople = new ArrayList<>();
        
        String s = scanner.nextLine();

        while (!s.equals("")){
            String[] arr = s.split(",");
            allPeople.add(arr);
            s = scanner.nextLine();
        }
        int sum = 0;
        String longest = "";
        
        for(String[] person: allPeople){
            sum += Integer.valueOf(person[1]);
            if(person[0].length() > longest.length()){
                longest = person[0];
            }
        }
        
        System.out.println("Longest name : "+longest);
        System.out.println("Average of the birth years: "+1.0*sum/allPeople.size());


    }
}
