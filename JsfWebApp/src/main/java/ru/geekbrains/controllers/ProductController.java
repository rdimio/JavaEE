package ru.geekbrains.controllers;

import ru.geekbrains.entity.Category;
import ru.geekbrains.entity.Product;
import ru.geekbrains.services.interfaces.CategoryIntService;
import ru.geekbrains.services.interfaces.ProductIntService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

    @EJB
    private ProductIntService productService;

    @EJB
    private CategoryIntService categoryService;

    private Product product;
    private Category category;
    private Long category_id;

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }

    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) {
        productService.delete(product.getId());
    }

    public String saveProduct() {
        category = findById(category_id);
        product.setCategory(category);
        if (product.getId() == null) {
            productService.insert(product);
        } else {
            productService.update(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public Category findById(Long id){
        return categoryService.findById(id);
    }
}
