package web.service;
import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    boolean deleteUser(int id);

    boolean updateUser(User user);

    public User getUserById(int id);
    public boolean addUser(User user);

    public User getUserByLogAndPass(String login, String password);

    User getUserByLogin(String login);

    boolean isExistLogin(String login);
}
