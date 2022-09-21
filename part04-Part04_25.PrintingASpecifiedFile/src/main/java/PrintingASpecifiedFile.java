/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingASpecifiedFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which file should have its contents printed?");
        String file = scanner.nextLine();
        try (Scanner scannerF = new Scanner(Paths.get(file))) {

        // we read the file until all lines have been read
        while (scannerF.hasNextLine()) {
            // we read one line
            String row = scannerF.nextLine();
            // we print the line that we read
            System.out.println(row);
        }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
