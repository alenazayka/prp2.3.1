package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public boolean addUser(User user) {
        userDAO.addUser(user);
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public boolean deleteUser(User user) {
        userDAO.deleteUser(user);
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public boolean updateUser(User user) {
        userDAO.updateUser(user);
        return true;
    }


    @Transactional(readOnly = true)
    @Override
    public User getUserByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean isExistLogin(String login) {
        return userDAO.isExistLogin(login);
    }
}
