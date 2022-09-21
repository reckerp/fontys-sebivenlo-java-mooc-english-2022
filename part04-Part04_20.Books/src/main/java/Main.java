/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // implement here the program that allows the user to enter 
        // book information and to examine them
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> arr = new ArrayList<>();
        while (true) {
            System.out.println("Title: ");
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }
            System.out.println("Pages: ");
            int pages = Integer.valueOf(scanner.nextLine());
            System.out.println("Publication year: ");
            int puby = Integer.valueOf(scanner.nextLine());
            arr.add(new Book(name, pages, puby));
        }
        
        System.out.println("What information will be printed? ");
        String s = scanner.nextLine();
        for (Book book : arr) {
            if (s.equals("everything")) {
                System.out.println(book);
            } else if (s.equals("name")) {
                System.out.println(book.getName());
            }
        }
    }
}