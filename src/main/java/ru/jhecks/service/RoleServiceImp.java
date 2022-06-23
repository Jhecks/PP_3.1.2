package ru.jhecks.service;

import org.springframework.stereotype.Service;
import ru.jhecks.model.Role;
import ru.jhecks.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role getRole(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    @Transactional
    public Role getRole(long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return (List<Role>) roleRepository.findAll();
    }
}
