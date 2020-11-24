package ru.itis.javalab.services;

import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUser() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return usersRepository.findFirstByEmailAndPassword(email, password);
    }

    @Override
    public void saveUser(Map pool) {
        User user = User.builder()
                .firstname((String) pool.get("firstname"))
                .lastname((String) pool.get("lastname"))
                .email((String) pool.get("email"))
                .password((String) pool.get("password"))
                .build();
        usersRepository.save(user);

    }
}
