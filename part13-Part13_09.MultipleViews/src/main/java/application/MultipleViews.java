package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {
  
    public static void main(String[] args) {
      launch(MultipleViews.class);
  }
    
    
    @Override
    public void start(Stage window) {
        // First scene
        BorderPane borderPane = new BorderPane();
        Button toSecondViewButton = new Button("To second view");
        borderPane.setTop(new Label("First view"));
        borderPane.setCenter(toSecondViewButton);
        
        // Second scene
        VBox vBox = new VBox();
        Button toThirdViewButton = new Button("To the third view");
        vBox.getChildren().addAll(toThirdViewButton, new Label("Second View"));
        
        // Third scene
        GridPane gridPane = new GridPane();
        Button toFirstViewButton = new Button("To the first view");
        gridPane.add(new Label("Third view"), 0, 0);
        gridPane.add(toFirstViewButton, 1, 1);

        Scene firstScene = new Scene(borderPane);
        Scene secondScene = new Scene(vBox);
        Scene thirdScene = new Scene(gridPane);

        // Events
        toFirstViewButton.setOnAction((event) -> {
            window.setScene(firstScene);
        });

        toSecondViewButton.setOnAction((event) -> {
            window.setScene(secondScene);
        });

        toThirdViewButton.setOnAction((event) -> {
            window.setScene(thirdScene);
        });


        window.setScene(firstScene);
        window.show();
    }

}