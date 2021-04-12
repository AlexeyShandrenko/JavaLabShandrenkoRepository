package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.services.SignUpService;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String getSignUpPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "sign_up";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String saveUser(@Valid UserForm userForm, BindingResult bindingResult, Model model) {
//        if (!bindingResult.hasErrors()) {
//            signUpService.signUp(userForm);
//            return "redirect:/login";
//        } else {
//            model.addAttribute("userForm", userForm);
//            return "sign_up";
//        }

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().anyMatch(error -> {
               if (Objects.requireNonNull(error.getCodes())[0].equals("userForm.ValidNames")) {
                   model.addAttribute("namesErrorMessage", error.getDefaultMessage());
               }
               if (Objects.requireNonNull(error.getCodes())[0].equals("userForm.ValidMatchPassword")) {
                   model.addAttribute("passwordMatchErrorMessage", error.getDefaultMessage());
               }
               return true;
            });
            model.addAttribute("userForm", userForm);
            return "sign_up";
        }
        signUpService.signUp(userForm);
        return "redirect:/login";

    }

}
