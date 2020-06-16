package web.service;
import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    boolean deleteUser(User user);

    boolean updateUser(User user);

    public User getUserById(int id);
    public boolean addUser(User user);

    User getUserByLogin(String login);

    boolean isExistLogin(String login);
}
