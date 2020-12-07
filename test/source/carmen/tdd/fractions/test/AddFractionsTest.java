package carmen.tdd.fractions.test;

import carmen.tdd.fractions.Fraction.Fraction;
import org.junit.Ignore;
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
        assertEquals(new Fraction(3), new Fraction(3).plus(new Fraction(0)));
    }

    @Test
    public void nonZeroPlusNonZero() {
        assertEquals(new Fraction(5), new Fraction(2).plus(new Fraction(3)));
    }

    @Test
    public void negativeNumberPlusPositiveNumber() {
        Fraction result = new Fraction(2).plus(new Fraction(-7));
        assertEquals(new Fraction(-5), result);
    }

    @Test
    public void commonDenominatorDifferentToOne() {
        Fraction result = new Fraction(1, 5).plus(new Fraction(2, 5));
        assertEquals(new Fraction(3, 5), result);
    }


    @Test
    public void wholeNumberNotEqualToDifferentWholeNumber() {
        assertNotEquals(new Fraction(6), new Fraction(5));
    }

    @Test
    public void differentDenominatorsWithoutReducing() {
        assertEquals(new Fraction(5, 6), new Fraction(1, 2).plus(new Fraction(1, 3)));
    }

    @Test
    public void reduceResultToWholeNumber() {
        assertEquals(new Fraction(1), new Fraction(1, 3).plus(new Fraction(2, 3)));
    }

    @Test
    public void oneDenominatorIsMultipleOfTheOther() {
        assertEquals(new Fraction(11, 8), new Fraction(3, 4).plus(new Fraction(5, 8)));
    }

    @Test
    public void commonFactorInDenominators() {
        assertEquals(new Fraction(11, 18), new Fraction(1, 6).plus(new Fraction(4, 9)));
    }

    @Test
    public void reduceResultEvenWhenDenominatorsAreTheSame() {
        assertEquals(new Fraction(3, 2), new Fraction(3, 4).plus(new Fraction(3, 4)));
    }

    @Test
    public void oneNegativeFractionAndReducing() {
        assertEquals(new Fraction(1, 2), new Fraction(-1, 4).plus(new Fraction(3, 4)));
        assertEquals(new Fraction(-1, 8), new Fraction(3, 8).plus(new Fraction(-1, 2)));
    }

    @Test
    @Ignore("Constructor  does not yet avoid negative denominators")
    public void negativeSignsEverywhere() {
        assertEquals(new Fraction(1, 2), new Fraction(1, -4).plus(new Fraction(-3, -4)));

    }
}

