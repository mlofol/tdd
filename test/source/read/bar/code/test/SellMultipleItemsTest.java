package read.bar.code.test;

import org.junit.Assert;
import org.junit.Ignore;
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
        }}, new HashMap<String, Integer>() {{
            put("123", 650);
        }});
        Sale sale = new Sale(display, catalog);
        sale.onBarcode("123");

        sale.onTotal();

        Assert.assertEquals("Total: $6.50", display.getTotal());
    }

    @Test
    public void oneItemNotFound() {
        Display display = new Display();
        Catalog catalog = new Catalog(new HashMap<String, String>() {{
            put("123", "$6.50");
        }}, new HashMap<String, Integer>() {{
            put("123", 650);
        }});
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("8888");
        sale.onTotal();

        Assert.assertEquals("No sale in progress. Try scanning a product.", display.getTotal());
    }

    @Test
    @Ignore
    public void sellSeveralItems() {
        Display display = new Display();
        Catalog catalog = new Catalog(new HashMap<String, String>() {
            {
                put("1", "$8.50");
                put("2", "$12.75");
                put("3", "$3.30");
            }
        }, new HashMap<String, Integer>() {
            {
                put("1", 850);
                put("2", 1275);
                put("3", 330);
            }
        });
        Sale sale = new Sale(display, catalog);
        sale.onBarcode("1");
        sale.onBarcode("2");
        sale.onBarcode("3");
        sale.onTotal();

        Assert.assertEquals("Total: $24.55", display.getTotal());

    }
}
