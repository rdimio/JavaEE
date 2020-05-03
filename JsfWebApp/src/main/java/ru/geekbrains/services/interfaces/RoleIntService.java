package ru.geekbrains.services.interfaces;

import ru.geekbrains.entity.Role;

import javax.ejb.Local;
import java.util.List;

@Local
public interface RoleIntService {
    List<Role> getAllRoles();
}
