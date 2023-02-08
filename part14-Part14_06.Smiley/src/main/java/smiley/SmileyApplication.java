package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SmileyApplication extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Canvas paintingCanvas = new Canvas(640, 480);
        
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();


        BorderPane layout = new BorderPane();
        layout.setCenter(paintingCanvas);

       
        painter.setFill(Color.BLACK);
        painter.fillRect(100, 100, 50, 50);
       
        painter.setFill(Color.BLACK);
        painter.fillRect(350, 100, 50, 50);
        
        painter.setFill(Color.BLACK);
        painter.fillRect(50, 250, 50, 50);
       
        painter.setFill(Color.BLACK);
        painter.fillRect(400, 250, 50, 50);
        
        painter.setFill(Color.BLACK);
        painter.fillRect(100, 300, 50, 50);
       
        painter.setFill(Color.BLACK);
        painter.fillRect(150, 300, 50, 50);
        
        painter.setFill(Color.BLACK);
        painter.fillRect(200, 300, 50, 50);
       
        painter.setFill(Color.BLACK);
        painter.fillRect(250, 300, 50, 50);
        
        painter.setFill(Color.BLACK);
        painter.fillRect(300, 300, 50, 50);
       
        painter.setFill(Color.BLACK);
        painter.fillRect(350, 300, 50, 50);

        
       
        
        Scene scene = new Scene(layout, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

}
