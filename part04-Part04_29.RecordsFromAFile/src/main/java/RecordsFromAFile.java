/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordsFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the file: ");
        String file = scanner.nextLine();
        
        try (Scanner scannerF = new Scanner(Paths.get(file))) {

        // we read the file until all lines have been read
            while (scannerF.hasNextLine()) {
                // we read one line
                String row = scannerF.nextLine();
                // we print the line that we read
                String[] arr = row.split(",");
                System.out.println(arr[0]+", age: "+arr[1]+" years");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
