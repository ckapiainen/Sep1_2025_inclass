package app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    void fahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32));
        assertEquals(100, converter.fahrenheitToCelsius(212));
        assertEquals(-40, converter.fahrenheitToCelsius(-40));
    }

    @Test
    void kelvinToCelsius() {
        assertEquals( -273.15, converter.kelvinToCelsius(0), 0.00001);
        assertEquals( -173.15, converter.kelvinToCelsius(100), 0.00001);
        assertThrows(IllegalArgumentException.class, () -> converter.kelvinToCelsius(-1));
    }

    @Test
    void celsiusToFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0));
        assertEquals(212, converter.celsiusToFahrenheit(100));
        assertEquals(-40, converter.celsiusToFahrenheit(-40));
    }

    @Test
    void isExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-41));
        assertTrue(converter.isExtremeTemperature(51));
        assertFalse(converter.isExtremeTemperature(0));
        assertFalse(converter.isExtremeTemperature(-40));
        assertFalse(converter.isExtremeTemperature(50));
    }


}
