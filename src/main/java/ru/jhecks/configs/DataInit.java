package ru.jhecks.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.jhecks.model.Role;
import ru.jhecks.model.User;
import ru.jhecks.service.RoleService;
import ru.jhecks.service.UserService;

import javax.annotation.PostConstruct;

@Component
@ComponentScan("ru.jhecks.service")
public class DataInit {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void init() {
        Role roleUser = new Role("USER");
        Role roleAdmin = new Role("ADMIN");
        roleService.createRole(roleUser);
        roleService.createRole(roleAdmin);

        User user = new User();
        user.setName("Ivan");
        user.setLastname("Ivanov");
        user.setAge(52);
        user.setUsername("user");
        user.setPassword("1234");

        User admin = new User();
        user.setName("Michael");
        user.setLastname("Semenov");
        user.setAge(22);
        user.setUsername("admin");
        user.setPassword("admin");


        userService.createUser(user);
        userService.createUser(admin);
    }
}
