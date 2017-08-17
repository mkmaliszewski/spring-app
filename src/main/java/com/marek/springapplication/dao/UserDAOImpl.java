package com.marek.springapplication.dao;

import com.marek.springapplication.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addUser(User newUser) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(newUser);
    }

    @Override
    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, username);

        return user;
    }    

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> listOfUsers = session.createQuery("from User").list();
        
        return listOfUsers;
    }

    @Override
    public void deleteUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, username);
        if (user != null){
            session.delete(user);
        }
    }
}
