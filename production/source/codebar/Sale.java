package codebar;

import java.util.HashMap;
import java.util.Map;

public class Sale {
    private Display display;
    private final Map<String, String> pricesByBarcode;

    public Sale(Display display, Map<String, String> pricesByBarcode) {
        this.display = display;
        this.pricesByBarcode = pricesByBarcode;
    }

    public void onBarcode(String barcode) {


        if ("".equals(barcode)) {
            display.setPrice("Scanning error: empty barcode");
        } else if (pricesByBarcode.containsKey(barcode)) {
            display.setPrice(pricesByBarcode.get(barcode));
        } else {
            display.setPrice("Product not found for " + barcode);
        }
    }
}
