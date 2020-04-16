package ru.geekbrains.controllers;

import ru.geekbrains.entity.Category;
import ru.geekbrains.services.interfaces.CategoryIntService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CategoryController implements Serializable {

    @EJB
    private CategoryIntService categoryService;

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String createCategory() {
        this.category = new Category();
        return "/category.xhtml?faces-redirect=true";
    }

    public List<Category> getAllCategory(){
        return categoryService.findAll();
    }

    public String editCategory(Category category) {
        this.category = category;
        return "/category.xhtml?faces-redirect=true";
    }

    public void deleteCategory(Category category){
        categoryService.delete(category.getId());
        //return "/index.xhtml?faces-redirect=true";
    }

    public String saveCategory(){
        if (category.getId() == null) {
            categoryService.insert(category);
        } else {
            categoryService.update(category);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}
