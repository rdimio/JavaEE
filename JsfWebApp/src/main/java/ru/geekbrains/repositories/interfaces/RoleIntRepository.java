package ru.geekbrains.repositories.interfaces;

import ru.geekbrains.entity.Role;

import javax.ejb.Local;
import java.util.List;

@Local
public interface RoleIntRepository {

    Role merge(Role role);

    Role findById(int id);

    List<Role> getAllRoles();

    long getCount();
}
