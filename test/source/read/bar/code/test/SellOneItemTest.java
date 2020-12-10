package read.bar.code.test;

import codebar.Sale;
import org.junit.Test;
import codebar.Display;

import static org.junit.Assert.assertEquals;

public class SellOneItemTest {
    @Test
    public void productFound() {
        Display display = new Display();
        Sale sale = new Sale();

        sale.onBarcode("12345");
        
        assertEquals("7.6euros",display.getText());
    }
}
