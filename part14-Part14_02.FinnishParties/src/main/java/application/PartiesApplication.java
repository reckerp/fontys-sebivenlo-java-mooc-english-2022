package application;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {
    private HashMap<String, HashMap<Integer, Double>> dataSet;

    public PartiesApplication() {
        dataSet = readFile("partiesdata.tsv");
    }

    @Override
    public void start(Stage stage) {
        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Support (RU)");

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        // go through the parties and add them to the chart
        dataSet.keySet().stream().forEach(party -> {
            // a different data set for each party
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            // add the party's support numbers to the data set
            dataSet.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            // and add the data to the chart
            lineChart.getData().add(data);
        });

        // display the line chart
        Scene view = new Scene(lineChart, 500, 400);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    private HashMap<String, HashMap<Integer, Double>> readFile(String path) {
        HashMap<String, HashMap<Integer, Double>> parts = new HashMap<>();
        ArrayList<Integer> years = new ArrayList<>();

        try(Scanner data = new Scanner(Paths.get(path))) {
            String row = data.nextLine();
            String[] stringArray = row.split("\t");
            for (int i = 1; i < stringArray.length; i++) { // skip first
                years.add(Integer.parseInt(stringArray[i]));
            }

            while (data.hasNext()) {
                String next = data.nextLine();
                stringArray = next.split("\t");
                String party = stringArray[0];
                HashMap<Integer, Double> map = new HashMap<>();
                for (int i = 1; i < stringArray.length; i++) {
                    if (!stringArray[i].equals("-")) {
                        int year = years.get(i-1);
                        String dat = stringArray[i];
                        double number = Double.parseDouble(dat);
                        map.put(year, number);
                    }

                }
                parts.put(party, map);
            }

        } catch(IOException e) {
            System.err.println("Error: " + e.toString());
        }

        return parts;
    }

}