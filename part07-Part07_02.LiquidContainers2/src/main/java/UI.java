import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Container first;
    private Container second;

    public UI(Scanner scanner, Container first, Container second) {
        this.scanner = scanner;
        this.first = first;
        this.second = second;
    }

    public void start() {
        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            if (command.equals("add")) {
                first.add(amount);
            } else if (command.equals("move")) {
                if (first.contains() < amount) {
                    second.add(first.contains());
                    first.remove(first.contains());
                } else {
                    second.add(amount);
                    first.remove(amount);
                }
            } else if (command.equals("remove")) {
                second.remove(amount);
            }
        }
    }
}
