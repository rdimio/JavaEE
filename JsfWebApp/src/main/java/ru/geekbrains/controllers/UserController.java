package ru.geekbrains.controllers;

import ru.geekbrains.entity.Role;
import ru.geekbrains.entity.User;
import ru.geekbrains.services.interfaces.RoleIntService;
import ru.geekbrains.services.interfaces.UserIntService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class UserController implements Serializable {

    @EJB
    private UserIntService userService;

    @Inject
    private RoleIntService roleService;

    private User user;

    private List<Role> roles;

    private List<User> users;

    public void preLoad() {
        this.roles = roleService.getAllRoles();
        this.users = userService.getAllUsers();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public String editUser(User user) {
        this.user = user;
        return "/admin/user.xhtml?faces-redirect=true";
    }

    public void deleteUser(User user) {
        userService.delete(user.getId());
    }

    public String createUser() {
        this.user = new User();
        return "/admin/user.xhtml?faces-redirect=true";
    }

    public String saveUser() {
        userService.merge(this.user);
        return "/admin/users.xhtml?faces-redirect=true";
    }

    public List<Role> getAllRoles() {
        return roles;
    }
}
