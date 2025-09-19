package app;

public class TemperatureConverter {

    public double fahrenheitToCelsius( double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public double kelvinToCelsius( double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Kelvin temperature cannot be negative.");
        }
        return kelvin - 273.15;
    }
    public double celsiusToFahrenheit( double celsius) {
        return celsius * 9 / 5 + 32;
    }
    public boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }

}
