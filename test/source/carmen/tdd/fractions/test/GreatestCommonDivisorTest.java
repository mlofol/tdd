package carmen.tdd.fractions.test;

import fraction.NumberTheory;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GreatestCommonDivisorTest {

    @Test
    public void oneAndOneShouldBeOne() {
        assertEquals(1, NumberTheory.greatestCommonDenominator(1, 1));
        assertEquals(2, NumberTheory.greatestCommonDenominator(2, 2));
        assertEquals(2, NumberTheory.greatestCommonDenominator(2, 6));

    }

    @Test
    public void primesFactors() {
        assertEquals(1, NumberTheory.greatestCommonDenominator(2, 3));
        assertEquals(1, NumberTheory.greatestCommonDenominator(4, 7));
        assertEquals(1, NumberTheory.greatestCommonDenominator(2, 3));
    }

    @Test
    public void oneIsMultipleOfTheOther() {
        assertEquals(3, NumberTheory.greatestCommonDenominator(3, 9));
        assertEquals(5, NumberTheory.greatestCommonDenominator(5, 30));
    }

    @Test
    public void commonFactor() {
        assertEquals(2, NumberTheory.greatestCommonDenominator(6, 8));
        assertEquals(7, NumberTheory.greatestCommonDenominator(49, 315));
    }

    @Test
    public void zero() {
        assertEquals(1, NumberTheory.greatestCommonDenominator(1,0));
        assertEquals(5, NumberTheory.greatestCommonDenominator(5,0));
        assertEquals(0, NumberTheory.greatestCommonDenominator(0,0));
    }
}
