package ru.geekbrains.services;

import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.CartRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CartService implements Serializable {

    @Inject
    private CartRepository cartRepository;

    @Transactional
    public void insert(Product product) {
        cartRepository.insert(product);
    }

    @Transactional
    public void delete(long id) {
        cartRepository.delete(id);
    }

    @Transactional
    public List<Product> findAll() {
        return cartRepository.findAll();
    }
}
