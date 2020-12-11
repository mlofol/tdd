package read.bar.code.test;

public class Sale {
    private final Catalog catalog;
    private Display display;

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
        String price = catalog.findPrice(barcode);
        if (price == null) {
            display.displayProductNotFoundMessage(barcode);
        } else {
            display.setPrice(price);
        }
    }

    public void onTotal() {
        display.displayNoSaleInProgressMessage();
    }

}
