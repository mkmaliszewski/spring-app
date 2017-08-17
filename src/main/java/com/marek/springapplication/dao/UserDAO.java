package com.marek.springapplication.dao;

import com.marek.springapplication.model.User;
import java.util.List;

public interface UserDAO {
    public void addUser(User newUser);
    
    public User getUser(String username);
    
    public List<User> getAllUsers();
    
    public void deleteUser(String username);
}
