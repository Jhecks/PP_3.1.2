package ru.jhecks.config;

import org.springframework.stereotype.Component;
import ru.jhecks.model.Role;
import ru.jhecks.model.User;
import ru.jhecks.repository.RoleRepository;
import ru.jhecks.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataInit {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DataInit(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    void init() {
        roleRepository.save(new Role("ADMIN", "Admin"));
        roleRepository.save(new Role("USER", "User"));

        userRepository.save(new User("Michael", "Semenov", 22,
                "admin", "admin", Set.of(roleRepository.findByName("ADMIN"))));
        userRepository.save(new User("Bogdan", "Ivanov", 10,
                "user", "1111", Set.of(roleRepository.findByName("USER"))));
    }
}