package ru.itis.javalab.utils;

import javax.mail.MessagingException;

public interface DebugService {
    void sendSimpleMessage(String to, String subject, String from) throws MessagingException;
}
