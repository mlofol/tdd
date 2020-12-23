package read.bar.code.test;

import java.util.Map;

public class Catalog {
    final Map<String, Integer> pricesByBarcodeInt;

    public Catalog(Map<String, Integer> pricesByBarcodeInt) {
        this.pricesByBarcodeInt = pricesByBarcodeInt;
    }

    public Integer findPrice(String barcode) {
        return pricesByBarcodeInt.get(barcode);
    }


}