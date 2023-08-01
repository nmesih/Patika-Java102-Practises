package PatikaStore.model;

public class Product {
    private int id;
    private double price;
    private double discountRate;
    private int stock;
    private String name;
    private Brand brand;

    public Product(int id, double price, double discountRate, int stock, String name, Brand brand) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public double getDiscountedPrice() {
        return price * (1 - discountRate);
    }
}
