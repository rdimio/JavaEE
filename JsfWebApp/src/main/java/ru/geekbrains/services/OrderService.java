package ru.geekbrains.services;

import ru.geekbrains.entity.Order;
import ru.geekbrains.repositories.OrderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    @Transactional
    public void insert(Order order) {
        orderRepository.insert(order);
    }

    @Transactional
    public void update(Order order)  {
        orderRepository.update(order);
    }

    @Transactional
    public void delete(long id) {
        orderRepository.delete(id);
    }

    @Transactional
    public Order findById(long id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}