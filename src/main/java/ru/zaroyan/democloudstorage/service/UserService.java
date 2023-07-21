package ru.zaroyan.democloudstorage.service;

import org.springframework.stereotype.Service;
import ru.zaroyan.democloudstorage.model.UserStorage;
import ru.zaroyan.democloudstorage.repository.UserStorageRepository;

@Service
public class UserService {
    private final UserStorageRepository userRepository;

    public UserService(UserStorageRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserStorage findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserStorage saveUser(UserStorage user) {
        return userRepository.save(user);
    }
}

