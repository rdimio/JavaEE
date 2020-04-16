package ru.geekbrains.services.interfaces;

import ru.geekbrains.entity.Order;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OrderIntService {

    void insert(Order order);

    void update(Order order);

    void delete(long id);

    Order findById(long id);

    List<Order> findAll();

}
