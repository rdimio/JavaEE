package ru.geekbrains.repositories.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Role;
import ru.geekbrains.repositories.interfaces.RoleIntRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class RoleRepository implements Serializable, RoleIntRepository {

    private Logger logger = LoggerFactory.getLogger(RoleRepository.class);

    @PersistenceContext(unitName = "Unit1")
    protected EntityManager em;

    @Override
    public Role merge(Role role) {
        return em.merge(role);
    }

    @Override
    public Role findById(int id) {
        return em.find(Role.class, id);
    }

    @Override
    public List<Role> getAllRoles() {
        return em.createQuery("from Role ", Role.class).getResultList();
    }

    @Override
    public long getCount() {
        return em.createQuery("select count(*) from Role", Long.class)
                .getSingleResult();
    }
}
