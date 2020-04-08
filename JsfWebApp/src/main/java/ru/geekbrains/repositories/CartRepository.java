package ru.geekbrains.repositories;

import ru.geekbrains.entity.Product;
import ru.geekbrains.utils.Cart;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CartRepository implements Serializable {

    @Inject
    private Cart cart;

    @PostConstruct
    public void init(){
       this.cart = new Cart();
    }

    public void insert(Product product) {
        cart.add(product);
    }

    public void delete(long id) {
        cart.delete(id);
    }

    public List<Product> findAll() {
        return cart.findAll();
    }

}
