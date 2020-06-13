package web.dao;
import web.model.User;
import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    void deleteUser(int id);

    void updateUser(User user);

    public User getUserById(int id);
    public void addUser(User user);

    public User getUserByLogAndPass(String login, String password);
    public boolean isExistLogin(String login);

}
