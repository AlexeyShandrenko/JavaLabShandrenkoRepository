package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.old.BCrypterService;
import ru.itis.javalab.services.old.LoginService;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private BCrypterService bCrypterService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "login";
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public ModelAndView login(UserForm userForm, HttpServletRequest request, HttpServletResponse response) {
//        String email = userForm.getEmail();
//        Optional<User> user = usersService.findUserByEmail(userForm.getEmail().trim());
//        if (user.isPresent() && bCrypterService.checkPassword(userForm.getPassword().trim(), user.get().getPassword())) {
//            loginService.login(userForm, request, response, user);
//            return new ModelAndView("redirect:/main_page");
//        } else {
//            return new ModelAndView("redirect:/login");
//        }

//    }



}
