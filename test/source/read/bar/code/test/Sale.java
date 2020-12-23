package read.bar.code.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Sale {
    private final Catalog catalog;
    private Display display;
    private Collection<Integer> pendingPurchaseItemPrices = new ArrayList<Integer>();

    public Sale(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        // SMELL Refused bequest; move this up the call stack
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }
        Integer priceInCents = catalog.findPrice(barcode);
        if (priceInCents == null) {
            display.displayProductNotFoundMessage(barcode);
        } else {
            //Refactor Eventually a shopping cart
            pendingPurchaseItemPrices.add(priceInCents);
            display.displayPrice(priceInCents);
        }
    }

    public void onTotal() {
        if (pendingPurchaseItemPrices.isEmpty()) {
            display.displayNoSaleInProgressMessage();
        } else {
            display.displayTotal(pendingPurchaseTotal());
        }
    }

    // Looks like model behaviour to me
    private Integer pendingPurchaseTotal() {
        return computePurchaseTotal(pendingPurchaseItemPrices);
    }

    public static Integer computePurchaseTotal(Collection<Integer> purchaseItemPrices) {
        return purchaseItemPrices.stream().collect(Collectors.summingInt(Integer::intValue));
    }

}
