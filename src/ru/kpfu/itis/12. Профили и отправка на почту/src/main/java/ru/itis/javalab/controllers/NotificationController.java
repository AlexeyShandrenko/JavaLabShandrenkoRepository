package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class NotificationController {

    @RequestMapping(value = "/notification", method = RequestMethod.GET)
    public String getNotificationPage() throws IOException {
        return "notification";
    }

}
