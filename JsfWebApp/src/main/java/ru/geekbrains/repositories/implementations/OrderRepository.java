package ru.geekbrains.repositories.implementations;

import ru.geekbrains.entity.Order;
import ru.geekbrains.repositories.interfaces.OrderIntRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OrderRepository implements OrderIntRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Order order) {
        em.persist(order);
    }

    @Override
    public void update(Order order)  {
        em.createQuery("UPDATE Order o SET " +
                "o.id = :id, o.name = :name, o.description = :description, o.price = :price")
                .setParameter("id", order.getId())
                .setParameter("name", order.getName())
                .setParameter("description", order.getDescription())
                .setParameter("price", order.getPrice())
                .executeUpdate();;
    }

    @Override
    public void delete(long id) {
        em.createQuery("DELETE FROM Order o WHERE o.id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public Order findById(long id) {
        return em.createQuery("SELECT o FROM Order o WHERE o.id = :id", Order.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("SELECT o FROM Order o ", Order.class).getResultList();
    }
}
