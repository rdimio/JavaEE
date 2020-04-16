package ru.geekbrains.repositories.interfaces;

import ru.geekbrains.entity.Order;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OrderIntRepository {

    void insert(Order order);

    void update(Order order);

    void delete(long id);

    Order findById(long id);

    List<Order> findAll();

}
