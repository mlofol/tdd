package carmen.tdd.fractions.test;

import carmen.tdd.fractions.Fraction.Fraction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}

