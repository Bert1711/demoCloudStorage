package ru.zaroyan.democloudstorage.service;

import org.springframework.stereotype.Service;
import ru.zaroyan.democloudstorage.model.User;
import ru.zaroyan.democloudstorage.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}

