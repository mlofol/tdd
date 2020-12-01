package carmen.tdd.fractions.test;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GreatestCommonDivisorTest {

    @Test
    public void oneAndOneShouldBeOne() {
        assertEquals(1,greatestCommonDenominator(1,1));
    }

    private int greatestCommonDenominator(int denominator1, int denominator2) {
        while (denominator2!=0){
            int tryWith= denominator2;
            denominator2 = denominator1 % tryWith;
            denominator1 = tryWith;
        }
        return denominator1;
    }
}
