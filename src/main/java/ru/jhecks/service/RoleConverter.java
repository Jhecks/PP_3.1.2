package ru.jhecks.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.jhecks.model.Role;

import javax.transaction.Transactional;

@Component
@Transactional
public class RoleConverter implements Converter<String, Role> {

    private final RoleService roleService;

    public RoleConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public Role convert(String roleName) {
        try {
            return roleService.getRole(roleName);
        } catch(Exception e) {
            System.out.println("Error."+ e);
            return null;
        }
    }
}
