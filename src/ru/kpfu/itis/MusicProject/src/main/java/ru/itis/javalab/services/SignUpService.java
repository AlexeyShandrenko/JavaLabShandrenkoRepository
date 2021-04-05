package ru.itis.javalab.services;

import ru.itis.javalab.dto.UserForm;

import javax.mail.MessagingException;

public interface SignUpService {
    void signUp(UserForm form) throws MessagingException;
}
