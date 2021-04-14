package ru.itis.javalab.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.security.details.UserDetailsImpl;

@Controller
public class ProfileController {

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("users", userDetails);
        return "profile";
    }

}
