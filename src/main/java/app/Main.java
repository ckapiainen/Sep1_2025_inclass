package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private final TemperatureConverter converter = new TemperatureConverter();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Temperature Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Celsius to Fahrenheit
        addConversionRow(grid, 0, "Celsius to Fahrenheit", "Celsius", converter::celsiusToFahrenheit);

        // Fahrenheit to Celsius
        addConversionRow(grid, 1, "Fahrenheit to Celsius", "Fahrenheit", converter::fahrenheitToCelsius);

        // Kelvin to Celsius
        addConversionRow(grid, 2, "Kelvin to Celsius", "Kelvin", converter::kelvinToCelsius);

        // Celsius to Kelvin
        addConversionRow(grid, 3, "Celsius to Kelvin", "Celsius", converter::celsiusToKelvin);

        Scene scene = new Scene(grid, 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    private void addConversionRow(GridPane grid, int row, String title, String inputUnit, ConversionFunction function) {
        Label titleLabel = new Label(title);
        TextField inputField = new TextField();
        inputField.setPromptText("Enter " + inputUnit);
        Button convertButton = new Button("Convert");
        Label resultLabel = new Label("Result:");

        convertButton.setOnAction(e -> {
            try {
                double input = Double.parseDouble(inputField.getText());
                double result = function.convert(input);
                resultLabel.setText(String.format("Result: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input!");
            } catch (IllegalArgumentException ex) {
                resultLabel.setText(ex.getMessage());
            }
        });

        grid.add(titleLabel, 0, row);
        grid.add(inputField, 1, row);
        grid.add(convertButton, 2, row);
        grid.add(resultLabel, 3, row);
    }

    @FunctionalInterface
    interface ConversionFunction {
        double convert(double value);
    }
}
