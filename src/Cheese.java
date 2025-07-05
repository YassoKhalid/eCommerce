import java.time.LocalDate;

public class Cheese extends Product implements Expirable, Shippable {
    LocalDate expiryDate;
    double weight;
    static final double ShippingFees = 50;

    Cheese(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return ShippingFees;
    }


    @Override
    public LocalDate getExpiryDateTime() {
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}

