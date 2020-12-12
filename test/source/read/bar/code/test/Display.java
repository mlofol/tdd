package read.bar.code.test;

public  class Display {

    private String price;
    private String total;

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

    public void displayPrice(String price) {
        setPrice(price);
    }

    public void displayTotal(String total) {
        setTotal("Total: " + total);
    }
}
