package ru.geekbrains.services.implementations;

import ru.geekbrains.entity.Order;
import ru.geekbrains.repositories.interfaces.OrderIntRepository;
import ru.geekbrains.services.interfaces.OrderIntService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;

@Stateless
public class OrderService implements OrderIntService {

    @EJB
    private OrderIntRepository orderRepository;

    @Override
    @TransactionAttribute
    public void insert(Order order) {
        orderRepository.insert(order);
    }

    @Override
    @TransactionAttribute
    public void update(Order order)  {
        orderRepository.update(order);
    }

    @Override
    @TransactionAttribute
    public void delete(long id) {
        orderRepository.delete(id);
    }

    @Override
    @TransactionAttribute
    public Order findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    @TransactionAttribute
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}