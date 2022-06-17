package ru.jhecks.dao;

import ru.jhecks.model.User;
import java.util.List;

public interface UserDAO {
    void createUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    User getUser(long id);
    List<User> getAllUsers();
}
