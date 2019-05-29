
package FunctionLayer;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaterialCalculatorTest {

    @Test
    public void round() {

        double tal = 20.23444444444;
        int decimaler = 2;

        double expected = 20.23;
        double result = FunctionLayer.MaterialCalculator.round(tal, decimaler);

        assertEquals(expected, result, 0);

    }

    @Test
    public void pladeBeregner(){

        int length = 780;
        int width = 600;
        double unit = 2.98;

        int expected = 16;
        int result = MaterialCalculator.pladeBeregner(width, length, unit);

        assertEquals(expected, result);
    }

    @Test
    public void ekstraStolpeUdregner(){

        int length = 780;
        int size = 0;
        int maxSpændvidde = 300;

        int expected = 4;
        int result = MaterialCalculator.ekstraStolpeUdregner(length, size, maxSpændvidde);

        assertEquals(expected, result);


    }
}

