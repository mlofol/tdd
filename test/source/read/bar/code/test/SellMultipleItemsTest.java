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
        Catalog catalog = new Catalog( new HashMap<String, Integer>() {{
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
        Catalog catalog = new Catalog( new HashMap<String, Integer>() {{
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
        Catalog catalog = new Catalog( new HashMap<String, Integer>() {
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

    @Test
    public void severalItemsSomeNotFound() {
        Display display = new Display();
        Catalog catalog = new Catalog( new HashMap<String, Integer>() {
            {
                put("1", 1200);
                put("2", 500);
            }
        });
        Sale sale = new Sale(display, catalog);
        sale.onBarcode("1");
        sale.onBarcode("you don't know this product");
        sale.onBarcode("2");
        sale.onTotal();

        Assert.assertEquals("Total: $17.00", display.getTotal());
    }
}
