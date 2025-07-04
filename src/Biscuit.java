import java.time.LocalDate;

public class Biscuit extends Product implements Expirable {
    public String CompanyName;
    LocalDate expiryDate;

    Biscuit(String name, double price, int quantity, String CompanyName, LocalDate expiryDate) {
        super(name, price, quantity);
        this.CompanyName = CompanyName;
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDateTime() {
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        return getExpiryDateTime().isBefore(LocalDate.now());
    }
}
