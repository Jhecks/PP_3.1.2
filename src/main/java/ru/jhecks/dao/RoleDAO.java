package ru.jhecks.dao;

import ru.jhecks.model.Role;

import java.util.List;

public interface RoleDAO {
    void createRole(Role role);
    void deleteRole(Role role);
    void updateRole(Role role);
    Role getRole(long id);
    List<Role> getAllRoles();
    Role getRole(String name);
}
