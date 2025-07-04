public class order {
    Customer customer;
    Cart cart;

    enum Status {pending, shipped, outForDelivery, delivered}

    Status status;

    public order(Customer customer, Status status) {
        this.customer = customer;
        this.cart = customer.cart;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void Checkout() {
        cart.Checkout(customer);
    }


    public void PlaceOrder() {
        Checkout();
    }
}
