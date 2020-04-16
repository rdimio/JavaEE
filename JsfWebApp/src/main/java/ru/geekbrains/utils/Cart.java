package ru.geekbrains.utils;

import ru.geekbrains.entity.Product;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class Cart implements Serializable {

    private List<Product> cart;

    public Cart() {
        cart = new ArrayList<>();
    }

    public void add(Product product) {
        cart.add(product);
    }

    public void delete(long id) {
        cart.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findAll() {
        return cart;
    }
}
