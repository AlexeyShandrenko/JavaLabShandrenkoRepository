package ru.kpfu.itis.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;

import static ru.kpfu.itis.dto.UserDto.from;

public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;
    private MailsService mailsService;

    public UsersServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder, MailsService mailsService) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailsService = mailsService;
    }

    public void signUp(String firstName, String lastName, String email, String password) {
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .hashPassword(passwordEncoder.encode(password))
                .build();
        usersRepository.save(user);
    }

    public void signIn(String email, String password) {
        usersRepository.findOneByEmail(email).ifPresent(user -> {
            if (passwordEncoder.matches(password, user.getHashPassword())) {
                mailsService.sendMail(email, "был выполнен вход в " + LocalDateTime.now().toString());
            }
        });
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers(int page, int size) {
        return from(usersRepository.findAll(page, size));
    }

    @Override
    public void addUsers(UserDto userDto) {
        usersRepository.save(User.builder()
                .firstName(userDto.getFirstname())
                .lastName(userDto.getLastname())
                .build());
    }

}
