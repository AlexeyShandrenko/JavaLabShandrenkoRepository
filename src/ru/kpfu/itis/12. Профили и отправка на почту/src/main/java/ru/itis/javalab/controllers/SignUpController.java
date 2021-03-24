package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.services.SignUpService;
import ru.itis.javalab.services.UsersService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@Controller
@Profile("master")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/notification", method = RequestMethod.GET)
    public String getNotificationPage() throws IOException {
        return "notification";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String getSignUpPage(Model model) throws IOException {
        model.addAttribute("userForm", new UserForm());
        return "login_window";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String signUp(@Valid UserForm userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().anyMatch(error -> {
                if (Objects.requireNonNull(error.getCodes())[0].equals("userForm.ValidNames")) {
                    model.addAttribute("namesErrorMessage", error.getDefaultMessage());
                }
                return true;
            });
            model.addAttribute("userForm", userForm);
            return "login_window";
        }
        signUpService.signUp(userForm);
        return "redirect:/notification";


    }

}
