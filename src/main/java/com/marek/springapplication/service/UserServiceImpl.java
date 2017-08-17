package com.marek.springapplication.service;

import com.marek.springapplication.dao.UserDAO;
import com.marek.springapplication.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    
    @Override
    public void addUser(User newUser) {
        userDAO.addUser(newUser);
    }

    @Override
    public User getUser(String username) {
        return userDAO.getUser(username);
    }    

    @Override
    public boolean isUsernameUnique(String username) {
        User user = userDAO.getUser(username);
        
        return user == null;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void deleteUser(String username) {
        userDAO.deleteUser(username);
    }
}
