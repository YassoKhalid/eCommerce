import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer cust = new Customer("Yassin", "yassenkhaled927@gmail.com", "01287663795", 100000.5);
        LocalDate expiryDate = LocalDate.now().plusDays(1);
        Cheese cheese = new Cheese("Cheese1", 15.0, 3, expiryDate, 0.25, 12.3);
        cartItem cartItem1 = new cartItem(cheese, 2);
        cust.AddItemToCart(cartItem1);
        TV tv = new TV("Samsung", 32, 10050, 3, 500);
        cust.AddItemToCart(new cartItem(tv, 1));
        cust.Checkout();
        order Order = new order(cust, order.Status.pending);
        Order.PlaceOrder();
    }
}