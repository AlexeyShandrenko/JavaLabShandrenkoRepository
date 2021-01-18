package ru.itis.javalab.services;

import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsersService {
    void saveUser(Map pool);
    List<User> getAllUser();
    List<UserDto> getAllUser(int page, int size);
    void addUser(UserDto userDto);
    Optional<User> findUserByEmailAndPassword(String email, String password);
    Optional<User> findUserByEmail(String email);
    UserDto getUser(Long userId);
}
