package ru.jhecks.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    public DataInit(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    void init() {
        roleRepository.save(new Role("ROLE_ADMIN", "Admin"));
        roleRepository.save(new Role("ROLE_USER", "User"));

        userRepository.save(new User("Michael", "Semenov", 22,
                "admin", passwordEncoder.encode("admin"), Set.of(roleRepository.findByName("ROLE_ADMIN"))));
        userRepository.save(new User("Bogdan", "Ivanov", 10,
                "user", passwordEncoder.encode("1111"), Set.of(roleRepository.findByName("ROLE_USER"))));
    }
}