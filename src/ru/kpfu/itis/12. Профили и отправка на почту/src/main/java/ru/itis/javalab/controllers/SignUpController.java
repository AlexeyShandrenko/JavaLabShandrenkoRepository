package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
    private UsersService usersService;

    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String getSignUpPage() throws IOException {
        return "login_window";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> map = new HashMap<>();
        String password = request.getParameter("password");
        String password_repeat = request.getParameter("password_repeat");
        if (password.equals(password_repeat)) {
            map.put("firstname", request.getParameter("firstname"));
            map.put("lastname", request.getParameter("lastname"));
            map.put("email", request.getParameter("email"));
            map.put("password", request.getParameter("password"));
            map.put("age", request.getParameter("age"));
            try {
                usersService.saveUser(map);
            } catch (MessagingException e) {
                throw new IllegalArgumentException(e);
            }
            return new ModelAndView("redirect:/notification");
        } else {
            return new ModelAndView("redirect:/sign_up");
        }

    }


}
