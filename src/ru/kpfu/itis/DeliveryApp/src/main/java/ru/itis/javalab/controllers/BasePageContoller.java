package ru.itis.javalab.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasePageContoller {

    @RequestMapping(value = "/base_page", method = RequestMethod.GET)
    public String getBasePage(Authentication authentication) {
        if (authentication != null) {
            return "profile";
        } else {
            return "base_page";
        }

    }

}
