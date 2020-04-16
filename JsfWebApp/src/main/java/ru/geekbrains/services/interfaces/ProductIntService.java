package ru.geekbrains.services.interfaces;

import ru.geekbrains.entity.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductIntService {

    void insert(Product product);

    void update(Product product);

    void delete(long id);

    Product findById(long id);

    List<Product> findAll();

}
