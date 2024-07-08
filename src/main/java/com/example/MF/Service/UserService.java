package com.example.MF.Service;


import com.example.MF.Dto.UserDto;
import com.example.MF.Entity.User;

public interface UserService {
    User save (UserDto userDto);
    Iterable<User> findUsers();
    User getUserId(Long id);
    void deleteUser(Long id);
}
