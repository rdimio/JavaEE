package ru.geekbrains.services.implementations;

import ru.geekbrains.entity.Product;
import ru.geekbrains.services.interfaces.ProductIntService;
import ru.geekbrains.services.interfaces.SoapIntService;

import javax.ejb.EJB;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.geekbrains.services.interfaces.SoapIntService", serviceName = "SoapService")
public class SoapService implements SoapIntService {

    @EJB
    private ProductIntService productIntService;

    @Override
    public List<Product> getAllProducts() {
        return productIntService.findAll();
    }

    @Override
    public void insertProduct(Product product) {
        productIntService.insert(product);
    }

    @Override
    public void updateProduct(Product product) {
        productIntService.update(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productIntService.delete(id);
    }

    @Override
    public Product getById(Long id) {
        return productIntService.findById(id);
    }


}
