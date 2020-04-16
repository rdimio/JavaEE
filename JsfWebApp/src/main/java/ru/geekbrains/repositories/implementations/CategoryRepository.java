package ru.geekbrains.repositories.implementations;

import ru.geekbrains.entity.Category;
import ru.geekbrains.repositories.interfaces.CategoryIntRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Stateless
public class CategoryRepository implements CategoryIntRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Category category) {
        em.persist(category);
    }

    @Override
    public void update(Category category)  {
        em.merge(category);
    }

    @Override
    public void delete(long id) {
        Category category = em.find(Category.class,id);
        if(category != null) {
            em.remove(category);
        }
    }

    @Override
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

    @Override
    public List<Category> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> query = cb.createQuery(Category.class);
        Root<Category> c = query.from(Category.class);
        query.select(c);
        TypedQuery<Category> q = em.createQuery(query);
        return q.getResultList();
    }

}
