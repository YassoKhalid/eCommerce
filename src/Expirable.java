import java.time.LocalDate;

public interface Expirable {
    LocalDate getExpiryDateTime();
    boolean isExpired();
}
