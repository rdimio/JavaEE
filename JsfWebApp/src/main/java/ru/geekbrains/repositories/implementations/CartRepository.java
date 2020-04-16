package ru.geekbrains.repositories.implementations;

import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.interfaces.CartIntRepository;
import ru.geekbrains.utils.Cart;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class CartRepository implements Serializable, CartIntRepository {

    @EJB
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
