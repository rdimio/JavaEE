package ru.geekbrains.services;

import ru.geekbrains.entity.Category;
import ru.geekbrains.repositories.CategoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class CategoryService {

    @Inject
    private CategoryRepository categoryRepository;

    @Transactional
    public void insert(Category category) {
        categoryRepository.insert(category);
    }

    @Transactional
    public void update(Category category)  {
        categoryRepository.update(category);
    }

    @Transactional
    public void delete(long id) {
        categoryRepository.delete(id);
    }

    @Transactional
    public Category findById(long id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
