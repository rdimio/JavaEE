package ru.geekbrains.repositories.interfaces;

import ru.geekbrains.entity.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductIntRepository {

    void insert(Product product);

    void update(Product product);

    void delete(long id);

    Product findById(long id);

    List<Product> findAll();

}
