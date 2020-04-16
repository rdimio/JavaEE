package ru.geekbrains.services.interfaces;

import ru.geekbrains.entity.Category;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryIntService {

    void insert(Category category);

    void update(Category category);

    void delete(long id);

    Category findById(long id);

    List<Category> findAll();

}
