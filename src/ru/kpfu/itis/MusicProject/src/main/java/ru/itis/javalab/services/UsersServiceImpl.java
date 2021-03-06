package ru.itis.javalab.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static ru.itis.javalab.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void saveUser(Map pool) {
        User user = User.builder()
                .firstname((String) pool.get("firstname"))
                .lastname((String) pool.get("lastname"))
                .email((String) pool.get("email"))
                .password(passwordEncoder.encode((String) pool.get("password")))
                .age((String) pool.get("age"))
                .build();
        usersRepository.save(user);
    }

    @Override
    public void updateUser(Map pool) {
        User user = User.builder()
                .firstname((String) pool.get("firstname"))
                .lastname((String) pool.get("lastname"))
                .age((String) pool.get("age"))
                .build();
        usersRepository.update(user, (Long) pool.get("id"));
    }

    @Override
    public List<User> getAllUser() {
        return usersRepository.findAll();
    }

    @Override
    public List<UserDto> getAllUser(int page, int size) {
        return from(usersRepository.findAll(page, size));
    }

    @Override
    public void addUser(UserDto userDto) {
        usersRepository.save(User.builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .build());
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return usersRepository.findFirstByEmailAndPassword(email, password);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return usersRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> findUserByPassword(String password) {
        return usersRepository.findUserByPassword(password);
    }

    @Override
    public UserDto getUser(Long userId) {
        return UserDto.from(usersRepository.findById(userId).orElse(null));
    }

}
