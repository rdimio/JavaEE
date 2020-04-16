package ru.geekbrains.services.interfaces;

import ru.geekbrains.entity.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CartIntService {

    void insert(Product product);

    void delete(long id);

    List<Product> findAll();

}
