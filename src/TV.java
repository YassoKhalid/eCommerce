public class TV extends Product implements Shippable {
    public double weight;
    public double ShippingFees;

    TV(String name, double weight, double price, int quantity, double ShippingFees) {
        super(name, price, quantity);
        this.weight = weight;
        this.ShippingFees = ShippingFees;
    }



    @Override
    public double getWeight() {
        return ShippingFees;
    }

}
