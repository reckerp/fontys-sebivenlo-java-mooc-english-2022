/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        // implement here your program that uses the PersonalInformation class

        ArrayList<PersonalInformation> infoCollection = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("First name: ");
            String fname = scanner.nextLine();
            if (fname.equals("")) {
                break;
            }
            System.out.println("Last name: ");
            String lname = scanner.nextLine();
            
            System.out.println("Identification number: ");
            String inum = scanner.nextLine();
            
            infoCollection.add(new PersonalInformation(fname, lname, inum));
            
            for (PersonalInformation personalInformation : infoCollection) {
                System.out.println(personalInformation.getFirstName() +" "+personalInformation.getLastName());
            }
        }

    }
}
