import java.util.List;

public class ShippingService {
    public static void Ship(List<Shippable> cartItems) {
        for (Shippable shippable : cartItems) {
            System.out.println(shippable.getName() + " " + shippable.getWeight());
        }
    }

}
