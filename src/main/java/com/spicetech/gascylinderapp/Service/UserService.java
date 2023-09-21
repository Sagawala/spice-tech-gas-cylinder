package com.spicetech.gascylinderapp.Service;


import com.spicetech.gascylinderapp.Entity.User;
import com.spicetech.gascylinderapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUserById(Long id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
