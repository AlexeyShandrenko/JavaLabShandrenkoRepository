package ru.itis.javalab.services;

import ru.itis.javalab.models.User;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsersService {

    List<User> getAllUser();
    List<User> findUserByEmailAndPassword(String email, String password);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByPassword(String password);
    void updateUser(Map pool);

}
