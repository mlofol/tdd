package read.bar.code.test;

import java.util.List;

public class Sale {
    private final Catalog catalog;
    private Display display;
    private String scannedPrice;
    private List<String> scannedPrices;

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
        scannedPrice = catalog.findPrice(barcode);
        if (scannedPrice == null) {
            display.displayProductNotFoundMessage(barcode);
        } else {
            display.displayPrice(scannedPrice);
        }
    }

    public void onTotal() {
        boolean saleInProgress = (scannedPrice != null);
        if (saleInProgress) {
            display.displayTotal(scannedPrice);
        } else {
            display.displayNoSaleInProgressMessage();
        }
    }

}
