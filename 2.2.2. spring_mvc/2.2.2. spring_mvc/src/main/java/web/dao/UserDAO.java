package web.dao;
import web.model.User;
import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    void deleteUser(User user);

    void updateUser(User user);

    public User getUserById(int id);
    public void addUser(User user);
    public boolean isExistLogin(String login);
    User getUserByLogin(String login);

}
