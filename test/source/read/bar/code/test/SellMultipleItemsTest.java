package read.bar.code.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class SellMultipleItemsTest {
    @Test
    public void zeroItems() {
        Display display = new Display();
        Sale sale = new Sale(display, null);

        sale.onTotal();

        Assert.assertEquals("No sale in progress. Try scanning a product.", display.getTotal());
    }

    @Test
    public void oneItems() {
        Display display = new Display();
        Catalog catalog = new Catalog(new HashMap<String, String>() {{
            put("123", "$6.50");
        }});
        Sale sale = new Sale(display, catalog);
        sale.onBarcode("123");

        sale.onTotal();

        Assert.assertEquals("Total: $6.50", display.getTotal());
    }
}
