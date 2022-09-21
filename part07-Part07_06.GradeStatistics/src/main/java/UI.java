import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private GradeController controller;

    public UI(GradeController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == -1) {
                break;
            }

            controller.addGrade(input);
        }

        System.out.println("Point average (all): " + controller.average());
        if (controller.passAverage() == 0) {
            System.out.println("Point average (passing): -");
        } else {
            System.out.println("Point average (passing): " + controller.passAverage());
        }
        System.out.println("Pass percentage: " + controller.passPercentage());

        int[] distribution = controller.gradeDistribution();
        System.out.println("Grade distribution:");
        for (int i = 5; i >= 0; i--) {
            System.out.print(i + ": ");
            for (int j = 0; j < distribution[i]; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
}
