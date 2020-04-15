package ru.geekbrains.services;

import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class ProductService {

    @Inject
    private ProductRepository productRepository;

    @Transactional
    public void insert(Product product) {
        productRepository.insert(product);
    }

    @Transactional
    public void update(Product product)  {
        productRepository.update(product);
    }

    @Transactional
    public void delete(long id) {
        productRepository.delete(id);
    }

    @Transactional
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
