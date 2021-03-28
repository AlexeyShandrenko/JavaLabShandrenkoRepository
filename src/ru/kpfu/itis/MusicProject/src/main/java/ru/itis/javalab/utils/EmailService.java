package ru.itis.javalab.utils;

import javax.mail.MessagingException;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String from, String text) throws MessagingException;

}
