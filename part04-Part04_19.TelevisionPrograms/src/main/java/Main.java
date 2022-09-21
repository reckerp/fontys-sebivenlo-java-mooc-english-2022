/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // implement here your program that uses the TelevisionProgram class

        ArrayList<TelevisionProgram> programs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Name: ");
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }
            System.out.println("Duration: ");
            int dur = Integer.valueOf(scanner.nextLine());
            programs.add(new TelevisionProgram(name, dur));
        }
        
        System.out.println("Program's maximum duration? ");
        int maxd = Integer.valueOf(scanner.nextLine());
        for (TelevisionProgram program : programs) {
            if (program.getDuration() <= maxd) {
                System.out.println(program);
            }
        }
    }
}