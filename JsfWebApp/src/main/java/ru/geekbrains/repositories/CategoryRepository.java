package ru.geekbrains.repositories;

import ru.geekbrains.entity.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@ApplicationScoped
@Named
public class CategoryRepository {

    @PersistenceContext
    private EntityManager em;


    public void insert(Category category) {
        em.persist(category);
    }

    public void update(Category category)  {
        em.merge(category);
    }

    public void delete(long id) {
        Category category = em.find(Category.class,id);
        if(category != null) {
            em.remove(category);
        }
    }

    public Category findById(long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> query = cb.createQuery(Category.class);
        Root<Category> c = query.from(Category.class);
        ParameterExpression<Long> p = cb.parameter(Long.class);
        Predicate condition = cb.equal(c.get("id"), p);
        query.select(c).where(condition);
        TypedQuery<Category> q = em.createQuery(query);
        q.setParameter(p, id);
        return q.getSingleResult();
    }

    public List<Category> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> query = cb.createQuery(Category.class);
        Root<Category> c = query.from(Category.class);
        query.select(c);
        TypedQuery<Category> q = em.createQuery(query);
        return q.getResultList();
    }

}
