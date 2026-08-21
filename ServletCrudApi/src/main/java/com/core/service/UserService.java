package com.core.service;

import com.core.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private final Map<Integer, User> userDB;

    public UserService() {
        userDB = new HashMap<>();
    }

    public User createUser(User user) {
        userDB.put(user.getId(), user);
        return user;
    }

    public User fetchUserById(Integer id) {
        return userDB.get(id);
    }

    public List<User> fetchAllUsers() {
        return new ArrayList<>(userDB.values());
    }

    public boolean updateUser(User user) {
        if (!userDB.containsKey(user.getId())) {
            return false;
        }

        userDB.put(user.getId(), user);
        return true;
    }

    public boolean deleteUser(Integer id) {
        return userDB.remove(id) != null;
    }
}