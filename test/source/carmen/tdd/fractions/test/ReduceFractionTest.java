package carmen.tdd.fractions.test;

import carmen.tdd.fractions.Fraction.Fraction;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReduceFractionTest {
    @Test
    public void alreadyInLowestTerms() {
        TestCase.assertEquals(new Fraction(3, 4), new Fraction(3, 4));
    }

    @Test
    // @Ignore("Waiting to implement GCD")
    public void reduceToNotWholeNumber() {
        assertEquals(new Fraction(3, 4), new Fraction(6, 8));
    }

    @Test
    public void reduceToWholeNumber() {
        assertEquals(new Fraction(6), new Fraction(24,4));
    }

    @Test
    public void reduceZero() {
        assertEquals(new Fraction(0), new Fraction(0,17895));
    }
}