package read.bar.code.test;

import java.util.Locale;

public class Display {

    private String price;
    private String total;

    // Smell move this behaviour
    public static String format(int priceInCents) {
        double amount = priceInCents / 100.0d;
        return "" + String.format(Locale.ROOT, "$%,.2f", amount);
    }

    public String getText() {
        return price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void displayNoSaleInProgressMessage() {
        setTotal("No sale in progress. Try scanning a product.");
    }

    public void displayEmptyBarcodeMessage() {
        setPrice("Scanning error: empty barcode");
    }

    public void displayProductNotFoundMessage(String barcode) {
        setPrice("Product not found for " + barcode);
    }

    public void displayText(String price) {
        setPrice(price);
    }

    public void displayTotal(String total) {
        setTotal("Total: " + total);
    }
}
