package read.bar.code.test;

import codebar.Sale;
import org.junit.Ignore;
import org.junit.Test;
import codebar.Display;

import static org.junit.Assert.assertEquals;

public class SellOneItemTest {
    @Test
    public void productFound() {
        Display display = new Display();
        Sale sale = new Sale(display);

        sale.onBarcode("12345");

        assertEquals("7.6euros",display.getText());
    }

    @Test
    public void anotherProductFound() {
        Display display = new Display();
        Sale sale = new Sale(display);

        sale.onBarcode("12346");

        assertEquals("0.6euros",display.getText());
    }

    @Test
    public void productNotFound() {
        Display display = new Display();
        Sale sale = new Sale(display);

        sale.onBarcode("999");

        assertEquals("Product not found for 999", display.getText());
    }
}
