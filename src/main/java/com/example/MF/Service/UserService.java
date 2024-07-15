package com.example.MF.Service;


import com.example.MF.Entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();


    void saveUser(User user);
    Iterable<User> findUsers();
    User getUserId(Long id);
    void deleteUser(Long id);
}
