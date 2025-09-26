package app;

public class Main {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();
        System.out.println("Temp Converter");
        System.out.println("26c to f: "+converter.celsiusToFahrenheit(26)+"f");
        System.out.println("273.15k to c: "+converter.kelvinToCelsius(273.15)+"c");
    }
}
