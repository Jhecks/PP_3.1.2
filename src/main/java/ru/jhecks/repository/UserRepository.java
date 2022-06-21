package ru.jhecks.repository;

import org.springframework.data.repository.CrudRepository;
import ru.jhecks.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
