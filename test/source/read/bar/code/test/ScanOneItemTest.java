package read.bar.code.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ScanOneItemTest {

    private Display display;
    private Sale sale;
    private Catalog catalog;
    private Catalog catalogInt;

    @Before
    public void setUp() throws Exception {
        display = new Display();
        catalog = new Catalog(new HashMap<String, String>() {
            {
                put("12345", "7.6euros");
                put("12346", "0.6euros");
            }
        }, new HashMap<String, Integer>() {
            {
                put("12345", 760);
                put("12346", 60);
            }
        });
        sale = new Sale(display, catalog);
    }

    @Test
    public void productFound() {

        sale.onBarcode("12345");

        assertEquals("$7.60", display.getText());
    }

    @Test
    public void anotherProductFound() {

        sale.onBarcode("12346");

        assertEquals("$0.60", display.getText());
    }

    @Test
    public void productNotFound() {


        sale.onBarcode("999");

        assertEquals("Product not found for 999", display.getText());
    }

    @Test
    public void anotherProductNotFound() {

        sale.onBarcode("990");

        assertEquals("Product not found for 990", display.getText());
    }

    @Test
    public void emptyBarcode() {
        Display display = new Display();
        // Null is an smell in a constructor. Violation of SRP
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("");

        Assert.assertEquals("Scanning error: empty barcode", display.getText());
    }
}
