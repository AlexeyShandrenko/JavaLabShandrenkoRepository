package ru.itis.javalab.util;

import javax.mail.MessagingException;

public interface DebugService {

    void sendSimpleMessage(String to, String subject, String from) throws MessagingException;

}
