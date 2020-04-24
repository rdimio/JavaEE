package ru.geekbrains.services.interfaces;

import ru.geekbrains.entity.Product;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface SoapIntService {

    @WebMethod
    List<Product> getAllProducts();

    @WebMethod
    void insertProduct(Product product);

    @WebMethod
    void updateProduct(Product product);

    @WebMethod
    void deleteProduct(Long id);

    @WebMethod
    Product getById(Long id);
}
