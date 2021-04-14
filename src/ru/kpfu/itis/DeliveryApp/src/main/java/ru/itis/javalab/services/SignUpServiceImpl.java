package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.utils.EmailService;
import ru.itis.javalab.utils.MailsGenerator;

import java.util.UUID;

@Service
@Profile("master")
public class SignUpServiceImpl implements SignUpService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MailsGenerator mailsGenerator;

    @Autowired
    private EmailService emailService;

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.mail.username}")
    private String from;

    public SignUpServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(UserForm userForm) {
        User newUser = User.builder()
                .firstname(userForm.getFirstname())
                .lastname(userForm.getLastname())
                .age(userForm.getAge())
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .confirm_code(UUID.randomUUID().toString())
                .status(User.Status.UNCONFIRMED)
                .role(User.Role.USER)
                .state(User.State.ACTIVE)
                .build();

        usersRepository.save(newUser);

        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirm_code());

        emailService.sendSimpleMessage(newUser.getEmail(), "Регистрация", from, confirmMail);
    }
}
