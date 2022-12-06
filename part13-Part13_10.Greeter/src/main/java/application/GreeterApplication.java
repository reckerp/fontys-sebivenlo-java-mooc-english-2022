package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application{


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Label instructions = new Label("Enter your name:");
        TextField nameInput = new TextField();
        Button start = new Button("Start");
        
        GridPane gridLayout = new GridPane();
        gridLayout.add(instructions, 0, 0);
        gridLayout.add(nameInput, 0, 1);
        gridLayout.add(start, 0, 2);
        
        gridLayout.setVgap(5);
        gridLayout.setHgap(5);
        gridLayout.setAlignment(Pos.CENTER);
        gridLayout.setPrefSize(250, 250);
        
        Scene firstScene = new Scene(gridLayout);
        
        
        Label greetings = new Label();
        GridPane greetingsLayout = new GridPane();
        greetingsLayout.add(greetings, 0,0);
        
        greetingsLayout.setVgap(5);
        greetingsLayout.setHgap(5);
        greetingsLayout.setAlignment(Pos.CENTER);
        greetingsLayout.setPrefSize(250, 250);
        
        Scene secondScene = new Scene(greetingsLayout);
        
        start.setOnAction((e)->{
            String name = nameInput.getText();
            greetings.setText("Welcome "+name+"!");
            window.setScene(secondScene);
                
        });
        
        
        window.setScene(firstScene);
        window.show();
    }
}
