package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application{


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        VBox layout = new VBox();
        
        Label output = new Label();
        TextField tField = new TextField();
        Button updateButton = new Button("Update");
        
        updateButton.setOnAction((event) -> {
            output.setText(tField.getText());
        });
        
        layout.setSpacing(20);
        layout.getChildren().addAll(tField, updateButton, output);
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }

}
