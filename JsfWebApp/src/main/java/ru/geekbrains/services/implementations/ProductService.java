package ru.geekbrains.services.implementations;

import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.interfaces.ProductIntRepository;
import ru.geekbrains.services.interfaces.ProductIntService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;

@Stateless
public class ProductService implements ProductIntService {

    @EJB
    private ProductIntRepository productRepository;

    @Override
    @TransactionAttribute
    public void insert(Product product) {
        productRepository.insert(product);
    }

    @Override
    @TransactionAttribute
    public void update(Product product)  {
        productRepository.update(product);
    }

    @Override
    @TransactionAttribute
    public void delete(long id) {
        productRepository.delete(id);
    }

    @Override
    @TransactionAttribute
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    @TransactionAttribute
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
