package ru.geekbrains.repositories.interfaces;

import ru.geekbrains.entity.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CartIntRepository {

    void insert(Product product);

    void delete(long id);

    List<Product> findAll();

}
