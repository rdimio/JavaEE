package ru.geekbrains.repositories;

import ru.geekbrains.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;


    public void insert(Product product) {
        em.persist(product);
    }

    public void update(Product product)  {
        em.createNamedQuery("Product.update")
                .setParameter("id", product.getId())
                .setParameter("name", product.getName())
                .setParameter("description", product.getDescription())
                .setParameter("price", product.getPrice())
                .setParameter("category", product.getCategory())
                .executeUpdate();;
    }

    public void delete(long id) {
        em.createNamedQuery("Product.delete").setParameter("id", id).executeUpdate();
    }

    public Product findById(long id) {
        return em.createNamedQuery("Product.findById",Product.class).setParameter("id", id).getSingleResult();
    }

    public List<Product> findAll() {
        return em.createNamedQuery("Product.findAll",Product.class).getResultList();
    }

}
