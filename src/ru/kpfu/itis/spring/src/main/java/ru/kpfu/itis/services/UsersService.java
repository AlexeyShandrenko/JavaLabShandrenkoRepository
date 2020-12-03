package ru.kpfu.itis.services;

import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.models.User;

import java.util.List;

public interface UsersService {
    void signUp(String firstname, String lastname, String email, String password);
    void signIn(String email, String password);
    List<User> getAllUsers();
    List<UserDto> getAllUsers(int page, int size);
    void addUsers(UserDto userDto);

}
