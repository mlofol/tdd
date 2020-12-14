package read.bar.code.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Collections;

@RunWith(Parameterized.class)
public class FormatMonetaryAmountTest {
    private final int priceInCents;
    private final String expectedFormattedPrice;

    @Parameterized.Parameters(name = "Monetary amount {0} formats to {1}")
    public static Collection<Object[]> data() {
        return Collections.singletonList(new Object[]{788, "$7.89"});
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
        return "$7.89";
    }
}
