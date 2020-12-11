package codebar;

import java.util.HashMap;
import java.util.Map;

public class Sale {
    private Display display;
    private final Map<String, String> pricesByBarcode;

    public Sale(Display display) {
        this.display = display;
        pricesByBarcode = new HashMap<>();
        pricesByBarcode.put("12345", "7.6euros");
        pricesByBarcode.put("12346", "0.6euros");
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
