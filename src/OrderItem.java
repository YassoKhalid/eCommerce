
public class OrderItem {
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public double getTotalPrice() {
        return product.getPrice();
    }
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
}
