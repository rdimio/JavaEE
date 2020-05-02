package ru.geekbrains.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.User;
import ru.geekbrains.repositories.interfaces.UserIntRepository;
import ru.geekbrains.services.interfaces.UserIntService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class UserService implements Serializable, UserIntService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @EJB
    private UserIntRepository userRepository;

    @TransactionAttribute
    public void merge(User user) {
        User merged = userRepository.merge(new User(user));
        user.setId(merged.getId());
    }

    @TransactionAttribute
    public void delete(int id) {
        userRepository.delete(id);
    }

    @TransactionAttribute
    public User findById(int id) {
        return new User(userRepository.findById(id));
    }

    @TransactionAttribute
    public boolean existsById(int id) {
        return userRepository.findById(id) != null;
    }

    @TransactionAttribute
    public List<User> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

}
