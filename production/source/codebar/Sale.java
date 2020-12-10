package codebar;

public class Sale {
    private Display display;

    public Sale(Display display) {
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("12345".equals(barcode)) {
            display.setPrice("7.6euros");
        } else if ("12346".equals(barcode)) {
            display.setPrice("0.6euros");
        }
        else{
            display.setPrice("Product not found for 999");
        }
    }
}
