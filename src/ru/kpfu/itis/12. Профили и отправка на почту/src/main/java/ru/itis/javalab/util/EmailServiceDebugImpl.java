package ru.itis.javalab.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
@Profile("dev")
public class EmailServiceDebugImpl implements DebugService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.properties.mail.debug}")
    private String mailDebug;

    @Value("${mail.transport.protocol}")
    private String protocol;

    @Override
    public void sendSimpleMessage(String to, String subject, String from) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        System.out.println(messageHelper);
    }
}
