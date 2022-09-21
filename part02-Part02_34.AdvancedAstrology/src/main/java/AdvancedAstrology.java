/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class AdvancedAstrology {

    public static void printStars(int number) {
        // first part of the exercise
        for (int i = 1; i <= number; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void printSpaces(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print(" ");
        }
    }

    public static void printTriangle(int size) {
        // part 2 of the exercise
        int count = 1;
        while (count <= size) {
            printSpaces(size - count);
            printStars(count);
            count++;
        }
    }

    public static void christmasTree(int height) {
        // part 3 of the exercise
        int count = 1;
        while (count <= height) {
            printSpaces(height - count);
            printStars(2 * count - 1);
            count++;
        }

        for (int i = 1; i <= 2; i++) {
            printSpaces(height - 2);
            printStars(3);
        }
    }

    public static void main(String[] args) {
        // The tests are not checking the main, so you can modify it freely.

        printTriangle(5);
        System.out.println("---");
        christmasTree(4);
        System.out.println("---");
        christmasTree(10);
    }
}
