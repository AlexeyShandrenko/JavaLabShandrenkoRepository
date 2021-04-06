package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    public SignUpServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(UserForm userForm) {
        User newUser = User.builder()
                .firstname(userForm.getFirstname())
                .lastname(userForm.getLastname())
                .age(Integer.parseInt(userForm.getAge()))
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .build();

        usersRepository.save(newUser);
    }
}
