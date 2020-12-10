package read.bar.code.test;

import codebar.Display;
import codebar.Sale;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SellOneItemTest {
    @Test
    public void productFound() {
        Display display = new Display();
        Sale sale = new Sale(display);

        sale.onBarcode("12345");

        assertEquals("7.6euros", display.getText());
    }

    @Test
    public void anotherProductFound() {
        Display display = new Display();
        Sale sale = new Sale(display);

        sale.onBarcode("12346");

        assertEquals("0.6euros", display.getText());
    }

    @Test
    public void productNotFound() {
        Display display = new Display();
        Sale sale = new Sale(display);

        sale.onBarcode("999");

        assertEquals("Product not found for 999", display.getText());
    }

    @Test
    public void anotherProductNotFound() {
        Display display = new Display();
        Sale sale = new Sale(display);

        sale.onBarcode("990");

        assertEquals("Product not found for 990", display.getText());
    }

    @Test
    public void emptyBarcode() {
        Display display = new Display();
        Sale sale = new Sale(display);

        sale.onBarcode("");

        Assert.assertEquals("Scanning error: empty barcode", display.getText());
    }
}
