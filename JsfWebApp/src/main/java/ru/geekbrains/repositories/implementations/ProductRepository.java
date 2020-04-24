package ru.geekbrains.repositories.implementations;

import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.interfaces.ProductIntRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductRepository implements ProductIntRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Product product) {
        em.persist(product);
    }

    @Override
    public void update(Product product)  {
/*        em.createNamedQuery("Product.update")
                .setParameter("name", product.getName())
                .setParameter("description", product.getDescription())
                .setParameter("price", product.getPrice())
                .setParameter("category", product.getCategory())
                .executeUpdate();;*/
        em.merge(product);
    }

    @Override
    public void delete(long id) {
        em.createNamedQuery("Product.delete").setParameter("id", id).executeUpdate();
    }

    @Override
    public Product findById(long id) {
        return em.createNamedQuery("Product.findById",Product.class).setParameter("id", id).getSingleResult();
    }

    public List<Product> findAll() {
        return em.createNamedQuery("Product.findAll",Product.class).getResultList();
    }

}
