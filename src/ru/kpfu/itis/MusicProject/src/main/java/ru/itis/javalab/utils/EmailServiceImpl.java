package ru.itis.javalab.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.concurrent.ExecutorService;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ExecutorService executorService;


    @Override
    public void sendSimpleMessage(String to, String subject, String from, String text) throws MessagingException {
        executorService.submit(() -> mailSender.send(mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(text, true);
        }));
    }
}
