package ru.geekbrains.services.implementations;

import ru.geekbrains.entity.Role;
import ru.geekbrains.repositories.interfaces.RoleIntRepository;
import ru.geekbrains.services.interfaces.RoleIntService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RoleService implements Serializable, RoleIntService {

    @Inject
    private RoleIntRepository roleRepository;

    @TransactionAttribute
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles().stream()
                .map(Role::new)
                .collect(Collectors.toList());
    }
}
