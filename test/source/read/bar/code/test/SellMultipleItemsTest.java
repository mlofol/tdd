package read.bar.code.test;

import org.junit.Assert;
import org.junit.Test;

public class SellMultipleItemsTest {
    @Test
    public void zeroItems() {
        Display display = new Display();

        Sale sale = new Sale(display, null);
        sale.onTotal();

        Assert.assertEquals("No sale in progress. Try scanning a product.", display.getTotal());
    }
}
