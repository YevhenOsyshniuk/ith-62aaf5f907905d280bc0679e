package ua.ithillel.lesson15.homework;

import java.time.LocalDateTime;

public class Product {
    private int ID;
    private String typeOfProduct;
    private double price;
    private boolean discount;
    private LocalDateTime dateTime;

    public Product(int ID, String type, double price, boolean discount, LocalDateTime dateTime) {
        this.ID = ID;
        this.typeOfProduct = type;
        this.price = price;
        this.discount = discount;
        this.dateTime = dateTime;
    }

       public Product(int ID, String typeOfProduct, double price) {
        this.ID = ID;
        this.typeOfProduct = typeOfProduct;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", type='" + typeOfProduct + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", dateTime=" + dateTime +
                '}';
    }
}
