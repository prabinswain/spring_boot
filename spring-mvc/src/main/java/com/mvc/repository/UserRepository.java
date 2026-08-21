package com.mvc.repository;

import com.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private Map<Integer, User> userMap;

    public UserRepository() {
        userMap = new HashMap<>();
    }

    public User save(User user) {
         userMap.put(user.getId(), user);
         return user;
    }

    public User findById(Integer id) {
        User user = userMap.get(id);

        if (user == null) {
            throw new RuntimeException("User not found with id: " + id);
        }

        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public User updateUser(User user){
        User user1 =  userMap.get(user.getId());
        if (user1 != null){
            return userMap.put(user.getId(), user);
        }
        return null;
    }

    public Boolean deleteUser(Integer id){
        User user1 =  userMap.get(id);
        if (user1 != null){
            userMap.remove(id);
            return true;
        }
        return false;
    }


}
