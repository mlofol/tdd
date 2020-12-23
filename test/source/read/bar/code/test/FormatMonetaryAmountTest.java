package read.bar.code.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FormatMonetaryAmountTest {
    private final int priceInCents;
    private final String expectedFormattedPrice;

    @Parameterized.Parameters(name = "Monetary amount {0} formats to {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {789, "$7.89"},
                {789, "$7.89"},
                {400, "$4.00"},
                {2, "$0.02"},
                {37, "$0.37"},
                {418976, "$4,189.76"},
                {210832281, "$2,108,322.81"},
                {0, "$0.00"}

        });
    }

    public FormatMonetaryAmountTest(int priceInCents, String expectedFormattedPrice) {
        this.priceInCents = priceInCents;
        this.expectedFormattedPrice = expectedFormattedPrice;
    }

    @Test
    public void test() {
        Assert.assertEquals(expectedFormattedPrice, Display.formatMonetaryAmount(priceInCents));
    }

}
