package ru.geekbrains.controllers;

import ru.geekbrains.entity.Order;
import ru.geekbrains.repositories.OrderRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class OrderController implements Serializable {

    @Inject
    private OrderRepository orderRepository;

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String createOrder() {
        this.order = new Order();
        return "/order.xhtml?faces-redirect=true";
    }

    public List<Order> getAllOrder() throws SQLException {
        return orderRepository.findAll();
    }

    public String editOrder(Order order) {
        this.order = order;
        return "/order.xhtml?faces-redirect=true";
    }

    public void deleteOrder(Order order) throws SQLException {
        orderRepository.delete(order.getId());
//        return "/index.xhtml?faces-redirect=true";
    }

    public String saveOrder() throws SQLException {
        if (order.getId() == null) {
            orderRepository.insert(order);
        } else {
            orderRepository.update(order);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}
