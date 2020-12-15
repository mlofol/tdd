package read.bar.code.test;

import java.util.ArrayList;
import java.util.Collection;

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
            pendingPurchaseItemPrices.add(priceInCents);
            display.displayPrice(priceInCents);
        }
    }

    public void onTotal() {
        boolean saleInProgress = (!pendingPurchaseItemPrices.isEmpty());
        if (saleInProgress) {
            display.displayTotal(Display.format(pendingPurchaseItemPrices.stream().findFirst().get()));
        } else {
            display.displayNoSaleInProgressMessage();
        }
    }

}
