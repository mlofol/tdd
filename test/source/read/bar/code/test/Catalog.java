package read.bar.code.test;

import java.util.Locale;
import java.util.Map;

public class Catalog {
    final Map<String, String> pricesByBarcodeText;
    final Map<String, Integer> pricesByBarcodeInt;

    public Catalog(Map<String, String> pricesByBarcodeText, Map<String, Integer> pricesByBarcodeInt) {
        this.pricesByBarcodeText = pricesByBarcodeText;
        this.pricesByBarcodeInt = pricesByBarcodeInt;
    }
// Smell move this behaviour
    public static String format(int priceInCents) {
        double amount = priceInCents / 100.0d;
        return "" + String.format(Locale.ROOT, "$%,.2f", amount);
    }

    public String findPriceThenFormatPrice(String barcode) {
        Integer priceInCents = pricesByBarcodeInt.get(barcode);
        if (priceInCents == null)
            return null;
        else
            return format(priceInCents);
    }


}