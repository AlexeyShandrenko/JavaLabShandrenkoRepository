package ru.kpfu.itis.services;

public interface UsersService {
    void signUp(String firstname, String lastname, String email, String password);
    void signIn(String email, String password);
}
