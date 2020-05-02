package ru.geekbrains.services.implementations;

import org.jboss.security.annotation.SecurityDomain;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repositories.interfaces.ProductIntRepository;
import ru.geekbrains.services.interfaces.ProductIntService;
import ru.geekbrains.services.interfaces.RestIntService;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;

@Stateless
@SecurityDomain("servlet-security-quickstart")
@PermitAll
public class ProductService implements ProductIntService, RestIntService {

    @EJB
    private ProductIntRepository productRepository;

    @Override
    @RolesAllowed("ADMIN")
    @TransactionAttribute
    public void insert(Product product) {
        productRepository.insert(product);
    }

    @Override
    @RolesAllowed("ADMIN")
    @TransactionAttribute
    public void update(Product product)  {
        productRepository.update(product);
    }

    @Override
    @RolesAllowed("ADMIN")
    @TransactionAttribute
    public void delete(long id) {
        productRepository.delete(id);
    }

    @Override
    @TransactionAttribute
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    @TransactionAttribute
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
