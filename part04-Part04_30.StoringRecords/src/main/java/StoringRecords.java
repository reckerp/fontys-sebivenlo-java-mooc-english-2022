
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StoringRecords {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Filename:");
        String file = scan.nextLine();

        ArrayList<Person> records = readRecordsFromFile(file);
        System.out.println("Persons: " + records.size());
        System.out.println("Persons:");
        for (Person person : records) {
            System.out.println(person);

        }
    }

    public static ArrayList<Person> readRecordsFromFile(String file) {
        ArrayList<Person> persons = new ArrayList<>();

        try (Scanner scannerF = new Scanner(Paths.get(file))) {

        // we read the file until all lines have been read
            while (scannerF.hasNextLine()) {
                // we read one line
                String row = scannerF.nextLine();
                // we print the line that we read
                String[] arr = row.split(",");
                persons.add(new Person(arr[0], Integer.valueOf(arr[1])));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // and printing the read records
        return persons;

    }
}
