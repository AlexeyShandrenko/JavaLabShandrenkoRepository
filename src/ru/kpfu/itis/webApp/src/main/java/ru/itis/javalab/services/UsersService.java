package ru.itis.javalab.services;

import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsersService {
    void saveUser(Map pool);
    List<User> getAllUser();
    Optional<User> findUserByEmailAndPassword(String email, String password);
}
