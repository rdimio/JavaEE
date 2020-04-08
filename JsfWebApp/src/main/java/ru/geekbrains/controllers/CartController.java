package ru.geekbrains.controllers;

import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.CartRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CartController implements Serializable {

    @Inject
    private CartRepository cartRepository;


    public List<Product> getAllCart() {
        return cartRepository.findAll();
    }

    public void deleteFromCart(Product product) {
        cartRepository.delete(product.getId());
    }

    public void saveToCart(Product product) {
        cartRepository.insert(product);
    }
}
