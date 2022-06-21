package ru.jhecks.repository;

import org.springframework.data.repository.CrudRepository;
import ru.jhecks.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}

