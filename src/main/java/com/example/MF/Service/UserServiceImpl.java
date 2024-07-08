package com.example.MF.Service;

import com.example.MF.Dto.UserDto;
import com.example.MF.Entity.User;
import com.example.MF.Repositories.UserRepository;
import org.hibernate.FetchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),
                userDto.getRole(), userDto.getFullname());
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserId(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new FetchNotFoundException("User", id));
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
