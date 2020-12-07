package carmen.tdd.fractions.test;

import carmen.tdd.fractions.Fraction.Fraction;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FractionEqualsTest {


    @Test
    public void oneShouldBeEqualToOne() {
        Assert.assertEquals(new Fraction(2), new Fraction(2));
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
    public void negativeDenominator() {
        assertEquals(new Fraction(1,2),new Fraction(-1,-2));
        assertEquals(new Fraction(-1,2),new Fraction(1,-2));
    }
}