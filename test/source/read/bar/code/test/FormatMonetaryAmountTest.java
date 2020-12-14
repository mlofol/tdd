package read.bar.code.test;

import org.junit.Assert;
import org.junit.Test;

public class FormatMonetaryAmountTest {
    @Test
    public void simplest() {
        Assert.assertEquals("$7.89", format(789));
    }

    private String format(int priceInCents) {
        return null;
    }
}
