package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserHibernateDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserHibernateDAO userHibernateDAO;

    @Transactional
    @Override
    public boolean addUser(User user) {
        userHibernateDAO.addUser(user);
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userHibernateDAO.getAllUsers();
    }

    @Transactional
    @Override
    public boolean deleteUser(int id) {
        userHibernateDAO.deleteUser(id);
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(int id) {
        return userHibernateDAO.getUserById(id);
    }

    @Transactional
    @Override
    public boolean updateUser(User user) {
        userHibernateDAO.updateUser(user);
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByLogAndPass(String login, String password) {
        return userHibernateDAO.getUserByLogAndPass(login, password);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean isExistLogin(String login) {
        return userHibernateDAO.isExistLogin(login);
    }
}
