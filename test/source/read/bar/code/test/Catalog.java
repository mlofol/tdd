package read.bar.code.test;

import java.util.Map;

public class Catalog {
    final Map<String, String> pricesByBarcodeText;
    final Map<String, Integer> pricesByBarcodeInt;

    public Catalog(Map<String, String> pricesByBarcodeText, Map<String, Integer> pricesByBarcodeInt) {
        this.pricesByBarcodeText = pricesByBarcodeText;
        this.pricesByBarcodeInt = pricesByBarcodeInt;
    }

    public String findPrice(String barcode){
        return pricesByBarcodeText.get(barcode);
    }


}