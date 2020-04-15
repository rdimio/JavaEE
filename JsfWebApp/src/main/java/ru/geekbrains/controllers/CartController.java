package ru.geekbrains.controllers;

import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.CartRepository;
import ru.geekbrains.services.CartService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CartController implements Serializable {

    @Inject
    private CartService cartService;


    public List<Product> getAllCart() {
        return cartService.findAll();
    }

    public void deleteFromCart(Product product) {
        cartService.delete(product.getId());
    }

    public void saveToCart(Product product) {
        cartService.insert(product);
    }
}
