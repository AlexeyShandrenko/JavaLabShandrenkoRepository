package ru.itis.javalab.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntryController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getEntry(Authentication authentication) {
        if (!authentication.isAuthenticated()) {
            return "base_page";
        } else {
            return "profile";
        }
    }

}
