package ru.geekbrains.services.interfaces;

import ru.geekbrains.entity.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserIntService {

    void merge(User user);

    void delete(int id);

    User findById(int id);

    boolean existsById(int id);

    List<User> getAllUsers();

}
