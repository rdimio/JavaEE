package ru.geekbrains.persist;

public class Order {

    private String name;
    private double price;
    private double count;

    public Order(){}

    public Order(String name, double price, double number) {
        this.name = name;
        this.price = price;
        count = price*number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCount() {
        return count;
    }

}
