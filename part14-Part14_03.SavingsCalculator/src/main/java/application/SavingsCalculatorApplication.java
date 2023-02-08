package application;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
    
    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) {
        // sliders layout (everything above chart)
        VBox sliders = new VBox();
        sliders.setPadding(new Insets(10, 20, 10, 20));
        
        
        // Cash layout
        BorderPane top = new BorderPane();
        Label cashLabel = new Label("Monthly savings");
        Label showCash = new Label("25.0");
        Slider cashSlider = new Slider(25, 250, 25);
        cashSlider.setShowTickLabels(true);
        cashSlider.setShowTickMarks(true);
        
        top.setLeft(cashLabel);
        top.setCenter(cashSlider);
        top.setRight(showCash);
        
        
        // Interest layout
        BorderPane bottom = new BorderPane();
        Label percentageLabel = new Label("Yearly interest rate");
        Label showPercentage = new Label("0");
        Slider percentageSlider = new Slider(0, 10, 0);
        percentageSlider.setShowTickMarks(true);
        percentageSlider.setShowTickLabels(true);
        percentageSlider.setMinorTickCount(10);
        
        bottom.setLeft(percentageLabel);
        bottom.setCenter(percentageSlider);
        bottom.setRight(showPercentage);
        
        // Add settings to sliders vbox
        sliders.getChildren().addAll(top,bottom);
        
        
        // Graph (line)
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");
        lineChart.setLegendVisible(false);
        lineChart.setAnimated(false);

        // Data Series
        XYChart.Series savingsSeries = new XYChart.Series();
        XYChart.Series savingsWithInterestSeries = new XYChart.Series();
        
        
        // Event listeners
        cashSlider.valueProperty().addListener((change, oldVal, newVal) -> {
            showCash.setText(String.valueOf((int)Math.round(newVal.doubleValue())));
            updateSavings(cashSlider.getValue(), percentageSlider.getValue(), savingsSeries, savingsWithInterestSeries);
        });
        
        
        percentageSlider.valueProperty().addListener((change, oldVal, newVal) -> {
            DecimalFormat df = new DecimalFormat("##.##");
            df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
            showPercentage.setText(df.format(newVal));
            updateSavings(cashSlider.getValue(), percentageSlider.getValue(), savingsSeries, savingsWithInterestSeries);
        });
        
        // init data
        updateSavings(cashSlider.getValue(), percentageSlider.getValue(), savingsSeries, savingsWithInterestSeries);

        // Add data to chart
        lineChart.getData().add(savingsSeries);
        lineChart.getData().add(savingsWithInterestSeries);
        
        // general layout
        BorderPane layout = new BorderPane();
        layout.setTop(sliders);
        layout.setCenter(lineChart);
        
        Scene view = new Scene(layout, 600, 550);
        stage.setScene(view);
        stage.show();
    }
   
    private void updateSavings(double savings, double interest,  XYChart.Series savingsSeries, XYChart.Series savingsWithInterestSeries) {
        // clear all previous data
        savingsSeries.getData().clear();
        savingsWithInterestSeries.getData().clear();
      
        double savs = 0.0;
        double intrs = 0.0;
        savingsSeries.getData().add(new XYChart.Data(0, savs));
        savingsWithInterestSeries.getData().add(new XYChart.Data(0, intrs));
        
        for (int i = 1; i <= 30; i++) {
            
            // yearly savings without interest
            savs += savings * 12;
            // with interest
            intrs = (intrs + (savings * 12)) * (1.0 + interest / 100.0);
            
            
            savingsSeries.getData().add(new XYChart.Data(i, savs));
            savingsWithInterestSeries.getData().add(new XYChart.Data(i, intrs));
            
        }
        System.out.println("Savings:");
        savingsSeries.getData().forEach(action-> System.out.println(action));
        System.out.println("\nSavings (Interest)");
        savingsWithInterestSeries.getData().forEach(action-> System.out.println(action));
    }


}