package com.marek.springapplication.service;

import com.marek.springapplication.model.User;
import java.util.List;

public interface UserService {
    public void addUser(User newUser);
    
    public User getUser(String username);
    
    public boolean isUsernameUnique(String username);
    
    public List<User> getAllUsers();
    
    public void deleteUser(String username);
}
