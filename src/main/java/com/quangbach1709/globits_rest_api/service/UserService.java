package com.quangbach1709.globits_rest_api.service;

import com.quangbach1709.globits_rest_api.model.User;
import com.quangbach1709.globits_rest_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User updateUser(int id, User user) {
        User user1 = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found for id: " + id)
        );
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found for id: " + id)
        );
        userRepository.deleteById(id);
    }
}
