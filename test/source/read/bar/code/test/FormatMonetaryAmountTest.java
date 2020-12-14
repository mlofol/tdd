package read.bar.code.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

@RunWith(Parameterized.class)
public class FormatMonetaryAmountTest {
    private final int priceInCents;
    private final String expectedFormattedPrice;

    @Parameterized.Parameters(name = "Monetary amount {0} formats to {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {789, "$7.89"},
                {520, "$5.20"}
        });
    }

    public FormatMonetaryAmountTest(int priceInCents, String expectedFormattedPrice) {
        this.priceInCents = priceInCents;
        this.expectedFormattedPrice = expectedFormattedPrice;
    }

    @Test
    public void test() {
        Assert.assertEquals(expectedFormattedPrice, format(priceInCents));
    }

    private String format(int priceInCents) {
        double amount = priceInCents / 100.0d;
        return ""                + String.format(Locale.ROOT,"$%.2f", amount);
    }
}
