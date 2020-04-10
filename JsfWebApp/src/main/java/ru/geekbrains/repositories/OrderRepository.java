package ru.geekbrains.repositories;

import ru.geekbrains.entity.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
@Named
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;


    public void insert(Order order) {
        em.persist(order);
    }

    public void update(Order order)  {
        em.createQuery("UPDATE Order o SET " +
                "o.id = :id, o.name = :name, o.description = :description, o.price = :price")
                .setParameter("id", order.getId())
                .setParameter("name", order.getName())
                .setParameter("description", order.getDescription())
                .setParameter("price", order.getPrice())
                .executeUpdate();;
    }

    public void delete(long id) {
        em.createQuery("DELETE FROM Order o WHERE o.id = :id").setParameter("id", id).executeUpdate();
    }

    public Order findById(long id) {
        return em.createQuery("SELECT o FROM Order o WHERE o.id = :id", Order.class).setParameter("id", id).getSingleResult();
    }

    public List<Order> findAll() {
        return em.createQuery("SELECT o FROM Order o ", Order.class).getResultList();
    }
}
