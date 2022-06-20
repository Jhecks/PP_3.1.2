package ru.jhecks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jhecks.dao.RoleDAO;
import ru.jhecks.model.Role;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleDAO roleDAO;

    public RoleServiceImp(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public void createRole(Role role) {
        roleDAO.createRole(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleDAO.deleteRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    @Override
    public Role getRole(String name) {
        return roleDAO.getRole(name);
    }

    @Override
    public Role getRole(long id) {
        return roleDAO.getRole(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }
}
