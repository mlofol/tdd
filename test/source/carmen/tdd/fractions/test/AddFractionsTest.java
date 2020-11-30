package carmen.tdd.fractions.test;

import carmen.tdd.fractions.Fraction.Fraction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AddFractionsTest {

    // Why What
    @Test
    public void zeroPlusZero() {
        Fraction result = new Fraction(0).plus(new Fraction(0));
        assertEquals(0, result.intValue());
    }

    @Test
    public void nonZeroPlusZero() {
        Fraction result = new Fraction(3).plus(new Fraction(0));
        assertEquals(3, result.intValue());
    }

    @Test
    public void nonZeroPlusNonZero() {
        Fraction result = new Fraction(2).plus(new Fraction(3));
        assertEquals(5, result.intValue());
    }

    @Test
    public void negativeNumberPlusPositiveNumber() {
        Fraction result = new Fraction(2).plus(new Fraction(-7));
        assertEquals(-5, result.intValue());
    }

    @Test
    public void commonDenominatorDifferentToOne() {
        Fraction result = new Fraction(1, 5).plus(new Fraction(2, 5));
        assertEquals(3, result.getNumerator());
        assertEquals(5, result.getDenominator());
        assertEquals(new Fraction(3,5), result);
    }

    @Test
    public void oneShouldBeEqualToOne() {
        assertEquals(new Fraction(2), new Fraction(2));
    }

    @Test
    public void oneThirdShouldBeEqualToOneThird() {
        assertEquals(new Fraction(1, 3), new Fraction(1, 3));
    }

    @Test
    public void wholeNumberEqualsSameFraction() {
        assertEquals(new Fraction(5), new Fraction(5, 1));
    }

    @Test
    public void wholeNumberNotEqualToDifferentWholeNumber() {
        assertNotEquals(new Fraction(6), new Fraction(5));
    }

}

