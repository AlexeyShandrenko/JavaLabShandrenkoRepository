package ru.itis.javalab.util;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String from,String text);

}
