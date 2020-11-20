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
}
