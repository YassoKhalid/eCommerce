import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<cartItem> cart = new ArrayList<cartItem>();

    public List<cartItem> getCart() {
        return cart;
    }

    public void setCart(List<cartItem> cart) {
        this.cart = cart;
    }

    double getCartTotal() {
        double total = 0;
        for (cartItem item : cart) {
            total += item.product.getPrice() * item.quantity;
        }
        return total;
    }

    double getPaidAmount() {
        return getCartTotal() + getCartShippingFees();
    }

    int getNumberOfItmes() {
        return cart.size();
    }

    boolean checkExpiry() {
        boolean expired = false;
        for (cartItem item : cart) {
            Product product = item.product;
            if (product instanceof Expirable) {
                Expirable expirable = (Expirable) product;
                if (expirable.isExpired()) {
                    expired = true;
                    break;
                }
            }
        }
        return expired;
    }

    boolean checkAvailability() {
        boolean availability = false;
        for (cartItem item : getCart()) {
            Product product = item.product;
            if (product.getQuantity() < item.quantity) {
                availability = true;
                break;
            }
        }
        return availability;
    }

    public void Checkout(Customer customer) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        boolean Expired = checkExpiry();
        boolean notAvailable = checkAvailability();

        if (Expired) {
            throw new IllegalStateException("There may be an Expired Items");
        }
        if (notAvailable) {
            throw new IllegalStateException("You ordered items more than available in the stock");
        }

        double total = getCartTotal();
        double shipping = getCartShippingFees();
        double paidAmount = total + shipping;
        if (paidAmount > customer.balance) {
            throw new IllegalStateException("Insufficient funds");
        }

        List<Shippable> ShippedElements = new ArrayList<>();
        for (cartItem item : getCart()) {
            Product product = item.product;
            if (product instanceof Shippable sp) {
                ShippedElements.add(sp);
            }
        }
        System.out.println("** Shipment Notice **");
        if (!ShippedElements.isEmpty()) {
            ShippingService.Ship(ShippedElements);
            double weigt = 0;
            for (cartItem shipps : getCart()) {
                Product product = shipps.product;
                if (!(product instanceof Shippable)) continue;
                Shippable Shipped = (Shippable) shipps.product;
                System.out.printf(
                        "%dx %-20s %4dg%n",
                        shipps.quantity,
                        shipps.product.getName(),
                        (int) (Shipped.getWeight() * 1000)
                );
                weigt += Shipped.getWeight() * shipps.quantity;
            }
            System.out.printf("Total package weight = %.1fkg%n", weigt);
        }

        System.out.println("** Checkout receipt **");
        for (cartItem item : getCart()) {
            System.out.printf(
                    "%dx %-20s %6.0f%n",
                    item.quantity,
                    item.product.getName(),
                    item.product.getPrice() * item.quantity
            );
        }

        System.out.println("--------------------");
        System.out.printf("Subtotal%7.0f%n", total);
        System.out.printf("Shipping%7.0f%n", shipping);
        System.out.printf("Amount%9.0f%n", paidAmount);
        customer.balance -= paidAmount;
    }

    double getCartShippingFees() {
        double total = 0;
        for (cartItem item : cart) {
            Product product = item.product;
            if (product instanceof Shippable shippable) {
                total += shippable.getWeight() * item.quantity;
            }
        }
        return total;
    }

    boolean isEmpty() {
        return cart.isEmpty();
    }

    public void addCartItem(cartItem cartItem) {
        int CountItems = cartItem.quantity;
        if (CountItems > cartItem.product.getQuantity()) {
            throw new IllegalArgumentException("Only " + cartItem.product.getQuantity() + "are available");
        } else if (CountItems <= 0) {
            throw new IllegalArgumentException("Quantity Can not be less than 1");
        } else {
            cart.add(cartItem);
        }
    }

    public void addCartItem(Product product, int quantity) {
        cartItem item = new cartItem(product, quantity);
        addCartItem(item);
    }

    public void removeCartItem(cartItem cartItem) {
        if (cart.contains(cartItem))
            cart.remove(cartItem);
        else {
            throw new IllegalArgumentException("CartItem does not exist.");
        }
    }

    public void clearCartItems() {
        cart.clear();
    }

    public void DisplayCartItems() {
        for (cartItem cartItem : cart) {
            System.out.println(cartItem);
        }
    }

}
