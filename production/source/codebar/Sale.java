package codebar;

import java.util.Map;

public class Sale {
    private Display display;
    private final Map<String, String> pricesByBarcode;

    public Sale(Display display, Map<String, String> pricesByBarcode) {
        this.display = display;
        this.pricesByBarcode = pricesByBarcode;
    }

    public void onBarcode(String barcode) {

// SMELL Refused bequest; move this up the call stack
        if ("".equals(barcode)) {
            display.setPrice("Scanning error: empty barcode");
            return;
        }
        if (pricesByBarcode.containsKey(barcode)) {
            display.setPrice(pricesByBarcode.get(barcode));
        } else {
            display.setPrice("Product not found for " + barcode);
        }
    }
}
