import java.util.ArrayList;
import java.util.List;

public class Customer {
    String name;
    String email;
    String PhoneNumber;
    double balance;
    Cart cart = new Cart();

    public Customer(String name, String email, String PhoneNumber, double balance) {
        this.name = name;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
        this.balance = balance;
    }

    public void AddItemToCart(cartItem item) {
        cart.addCartItem(item);
    }

    public void RemoveItemFromCart(cartItem item) {
        cart.removeCartItem(item);
    }

    public void Checkout() {
        cart.Checkout(this);
    }

}