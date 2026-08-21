package com.mvc.service;


import com.mvc.model.User;
import com.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Integer id) {
        return  userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public Boolean deleteUser(Integer id){
        return  userRepository.deleteUser(id);
    }
}
