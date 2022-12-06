package title;

import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What should be the title");
        String title = sc.nextLine();
        
        Application.launch(UserTitle.class, "--title="+title);

    }

}
