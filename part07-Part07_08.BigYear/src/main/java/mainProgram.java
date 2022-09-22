/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.Scanner;

public class mainProgram {

    public static void main(String[] args) {
        // NB! Do not create other scanner objects than the one below
        // if and when you create other classes, pass the scanner to them
        // as a parameter
        BirdDB birdDB = new BirdDB();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("?");
            String command = scan.nextLine();
            if (command.equals("Quit")) {
                break;
            }
            if (command.equals("Add")) {
                System.out.println("Name:");
                String name = scan.nextLine();
                System.out.println("Latin Name:");
                String latinName = scan.nextLine();
                Bird bird = new Bird(name, latinName);
                birdDB.addBird(bird);
            }
            if (command.equals("Observation")) {
                System.out.println("Bird?");
                String name = scan.nextLine();
                birdDB.addObservation(name);
            }
            if (command.equals("All")) {
                birdDB.printBirds();
            }
            if (command.equals("One")) {
                System.out.println("Bird?");
                String name = scan.nextLine();
                birdDB.printBird(name);
            }

        }
    }

}
