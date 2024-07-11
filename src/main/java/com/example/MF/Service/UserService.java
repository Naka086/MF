package com.example.MF.Service;


import com.example.MF.Entity.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user, String url);

    public void removeSessionMessage();

    public void sendEmail(User user, String path);

    public boolean verifyAccount(String verificationCode);

    public void increaseFailedAttempt(User user);


    public void resetFailedAttempt(String email);

    public void lock(User user);

    public boolean unlockWhenTimeExpired(User user);

    List<User> getAllUsers();

    User getUserByUsername(String username);

    void saveUser(User user);
    Iterable<User> findUsers();
    User getUserId(Long id);
    void deleteUser(Long id);
}
