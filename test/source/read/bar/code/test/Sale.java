package read.bar.code.test;

public class Sale {
    private final Catalog catalog;
    private Display display;
    private String scannedPrice;

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
            scannedPrice = Catalog.format(priceInCents);
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
