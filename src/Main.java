import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("Ship", "yassenkhaled927@gmail.com", "01287663795", 200000000);
        Cart cart = new Cart();
        LocalDate date = LocalDate.now();
        date = date.plusDays(1);
        Cheese chees = new Cheese("Gebna", 20.0, 5, date, 550.0);
        Mobile mb = new Mobile("Samasung S20", 1500, 20, "Samaung", "Galaxy", "White");
        Biscuit biscuit = new Biscuit("Fairy", 10.0, 20, "Egypt Foods", date);
        TV tv = new TV("SamSmart", 28000, 150000, 10, 15000);
        cart.addCartItem(biscuit, 10);
        cart.addCartItem(mb, 10);
        cart.addCartItem(new cartItem(ch, 4));
        cart.addCartItem(new cartItem(tv, 2));
        cart.Checkout(c);
    }
}