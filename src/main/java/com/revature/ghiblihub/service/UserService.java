package com.revature.ghiblihub.service;

import com.revature.ghiblihub.models.User;
import com.revature.ghiblihub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(RuntimeException::new);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean deleteUse(Integer id) {
        if(userRepository.findById(id).isPresent()) {
            userRepository.delete(userRepository.getById(id));
            return true;
        } else {
            return false;
        }
    }
}
