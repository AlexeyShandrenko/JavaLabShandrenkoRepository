package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.services.SignUpService;
import ru.itis.javalab.services.UsersService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Controller
@Profile("master")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String getSignUpPage() throws IOException {
        return "login_window";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String signUp(UserForm userForm) {
        signUpService.signUp(userForm);
        return "redirect:/notification";
    }

}
