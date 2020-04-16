package ru.geekbrains.controllers;

import ru.geekbrains.entity.Order;
import ru.geekbrains.services.interfaces.OrderIntService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class OrderController implements Serializable {

    @EJB
    private OrderIntService orderService;

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

    public List<Order> getAllOrder() {
        return orderService.findAll();
    }

    public String editOrder(Order order) {
        this.order = order;
        return "/order.xhtml?faces-redirect=true";
    }

    public void deleteOrder(Order order) {
        orderService.delete(order.getId());
//        return "/index.xhtml?faces-redirect=true";
    }

    public String saveOrder() {
        if (order.getId() == null) {
            orderService.insert(order);
        } else {
            orderService.update(order);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}
