package ru.geekbrains.repositories.interfaces;

import ru.geekbrains.entity.Category;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryIntRepository {

    void insert(Category category);

    void update(Category category);

    void delete(long id);

    Category findById(long id);

    List<Category> findAll();

}
