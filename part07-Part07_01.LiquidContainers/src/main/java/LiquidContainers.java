
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int volFirst = 0;
        int volSecond = 0;
        int volMax = 100;

        while (true) {

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            System.out.println("First: " + volFirst + "/" + volMax);
            System.out.println("Second: " + volSecond + "/" + volMax);

            if (command.equals("add") && amount >= 0) {
                if (volFirst <= volMax) {
                    volFirst += amount;
                    if (volFirst > volMax) {
                        volFirst = volMax;
                    }

                }
            } else if (command.equals("move") && amount >= 0) {
                if ((volFirst - amount) >= 0) {
                    volSecond += amount;
                    volFirst -= amount;
                    if (volSecond >= volMax) {
                        volSecond = volMax;
                    }
                } else if ((volFirst - amount) < 0) {
                    volSecond += volFirst;
                    volFirst = 0;
                    if (volSecond >= volMax) {
                        volSecond = volMax;
                    }
                }
            } else if (command.equals("remove") && amount >= 0) {
                if ((volSecond - amount) >= 0) {
                    volSecond -= amount;
                } else if ((volSecond - amount) < 0){
                    volSecond = 0;
                }
            }

        }

        System.out.println("First: " + volFirst + "/" + volMax);
        System.out.println("Second: " + volSecond + "/" + volMax);
    }

}