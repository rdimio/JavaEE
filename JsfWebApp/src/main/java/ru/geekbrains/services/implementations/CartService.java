package ru.geekbrains.services.implementations;

import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.interfaces.CartIntRepository;
import ru.geekbrains.services.interfaces.CartIntService;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import java.io.Serializable;
import java.util.List;

@Stateful
public class CartService implements Serializable, CartIntService {

    @EJB
    private CartIntRepository cartRepository;

    @Override
    @TransactionAttribute
    public void insert(Product product) {
        cartRepository.insert(product);
    }

    @Override
    @TransactionAttribute
    public void delete(long id) {
        cartRepository.delete(id);
    }

    @Override
    @TransactionAttribute
    public List<Product> findAll() {
        return cartRepository.findAll();
    }
}
