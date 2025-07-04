public class Mobile extends Product {
    public String Brand;
    public String Model;
    public String Color;

    Mobile(String name, double price, int quantity, String brand, String model, String color) {
        super(name, price, quantity);
        this.Brand = brand;
        this.Model = model;
        this.Color = color;
    }

    public String getBrand() {
        return Brand;
    }
    public void setBrand(String brand) {
        Brand = brand;
    }
    public String getModel() {
        return Model;
    }
    public void setModel(String model) {
        Model = model;
    }
    public String getColor() {
        return Color;
    }
    public void setColor(String color) {
        Color = color;
    }
}
