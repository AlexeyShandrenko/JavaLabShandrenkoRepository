package ru.itis.javalab.utils;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String from, String text);

}
