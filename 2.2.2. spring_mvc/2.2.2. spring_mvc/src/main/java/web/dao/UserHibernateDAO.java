package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserHibernateDAO implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void deleteUser(int id){
        User user = (User) sessionFactory.getCurrentSession().createQuery("from User WHERE id= :id")
                .setParameter("id", id)
                .uniqueResult();
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void updateUser(User user){
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getUserById(int id){
        User user = (User) sessionFactory.getCurrentSession().createQuery("from User WHERE id= :id")
                .setParameter("id", id)
                .uniqueResult();
        return user;
    }

    @Override
    public void addUser(User user){
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserByLogAndPass(String login, String password) {
        User user = (User) sessionFactory.getCurrentSession()
                .createQuery("from User WHERE login= :login and password = :password")
                .setParameter("login", login)
                .setParameter("password", password)
                .uniqueResult();
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = (User) sessionFactory.getCurrentSession()
                .createQuery("from User WHERE login= :login")
                .setParameter("login", login)
                .uniqueResult();
        return user;
    }

    @Override
    public boolean isExistLogin(String login) {
        User user = (User) sessionFactory.getCurrentSession()
                .createQuery("from User WHERE login= :login")
                .setParameter("login", login)
                .uniqueResult();
        return user != null;
    }
}
