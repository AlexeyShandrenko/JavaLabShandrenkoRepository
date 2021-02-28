package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.util.DebugService;
import ru.itis.javalab.util.EmailService;
import ru.itis.javalab.util.MailsGenerator;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Profile("dev")
public class UsersServiceFakeImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MailsGenerator mailsGenerator;

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private DebugService debugService;

    private PasswordEncoder passwordEncoder;

    public UsersServiceFakeImpl(UsersRepository usersRepository) {
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
                .confirm_code(UUID.randomUUID().toString())
                .age((String) pool.get("age"))
                .build();
        usersRepository.save(user);

        try {
            debugService.sendSimpleMessage(user.getEmail(), "Регистрация", from);
        } catch (MessagingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public List<UserDto> getAllUser(int page, int size) {
        return null;
    }

    @Override
    public void addUser(UserDto userDto) {

    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByPassword(String password) {
        return Optional.empty();
    }

    @Override
    public UserDto getUser(Long userId) {
        return null;
    }

    @Override
    public void updateUser(Map pool) {

    }
}
