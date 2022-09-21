/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class IsItInTheFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> filearr = new ArrayList<>();

        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        try (Scanner scannerF = new Scanner(Paths.get(file))) {

        // we read the file until all lines have been read
            while (scannerF.hasNextLine()) {
                // we read one line
                String row = scannerF.nextLine();
                // we print the line that we read
                filearr.add(row);
                
            }
        } catch (Exception e) {
            System.out.println("Reading the file nonexistent.txt failed.");
        }
        
        System.out.println("Search for:");
        String searchedFor = scanner.nextLine();
        
        if (filearr.contains(searchedFor)){
            System.out.println("Found!");
        } else {
            System.out.println("Not found.");
        }
        
    }
}
