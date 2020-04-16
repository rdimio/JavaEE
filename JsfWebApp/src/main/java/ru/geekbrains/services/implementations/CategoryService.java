package ru.geekbrains.services.implementations;

import ru.geekbrains.entity.Category;
import ru.geekbrains.repositories.interfaces.CategoryIntRepository;
import ru.geekbrains.services.interfaces.CategoryIntService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;

@Stateless
public class CategoryService implements CategoryIntService {

    @EJB
    private CategoryIntRepository categoryRepository;

    @Override
    @TransactionAttribute
    public void insert(Category category) {
        categoryRepository.insert(category);
    }

    @Override
    @TransactionAttribute
    public void update(Category category)  {
        categoryRepository.update(category);
    }

    @Override
    @TransactionAttribute
    public void delete(long id) {
        categoryRepository.delete(id);
    }

    @Override
    @TransactionAttribute
    public Category findById(long id) {
        return categoryRepository.findById(id);
    }

    @TransactionAttribute
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
