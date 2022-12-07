package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        
        HBox bottom = new HBox();
        bottom.setSpacing(10);
        
        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longestWord = new Label("The longest word is:");
        
        bottom.getChildren().add(letters);
        bottom.getChildren().add(words);
        bottom.getChildren().add(longestWord);
       
        
        TextArea textArea = new TextArea();
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            letters.setText("Letters: "+countLetters(newValue));
            words.setText("Words: "+countWords(newValue));
            longestWord.setText("The longest word is: "+ longestWord(newValue));
        });
        
        
        layout.setCenter(textArea);
        layout.setBottom(bottom);
       
        Scene view = new Scene(layout);
        window.setTitle("TextStatistics II");
        window.setScene(view);
        window.show();
    }

    public int countLetters(String text){
        return (int) text.chars().count();
    }
    
    public int countWords(String text){
        String[] words = text.split(" ");
        return (int) Arrays.stream(words).count();
    }
    
    public String longestWord(String text){
        String[] words = text.split(" ");
        return Arrays.stream(words)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
    }
}
