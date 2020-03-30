package ru.geekbrains.persist;

import java.util.ArrayList;
import java.util.List;

public class ProductList {


    private List<Product> products;

    public ProductList() {
        this.products = new ArrayList<>();
        this.products.add( new Product("Apple",1.2));
        this.products.add( new Product("Banana",1.1));
        this.products.add( new Product("Orange", 1));
        this.products.add( new Product("Potato", 0.8));
        this.products.add( new Product("Tomato", 1.5));
        this.products.add( new Product("Strawberry", 3));
        this.products.add( new Product("Pineapple",2.2));
        this.products.add( new Product("Grape",1.4));
        this.products.add( new Product("Cucumber",1.6));
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
