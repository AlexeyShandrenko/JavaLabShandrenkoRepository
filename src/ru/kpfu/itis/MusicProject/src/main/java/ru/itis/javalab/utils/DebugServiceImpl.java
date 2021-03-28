package ru.itis.javalab.utils;

import lombok.Value;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class DebugServiceImpl implements DebugService {
    @Override
    public void sendSimpleMessage(String to, String subject, String from) throws MessagingException {

    }
}
