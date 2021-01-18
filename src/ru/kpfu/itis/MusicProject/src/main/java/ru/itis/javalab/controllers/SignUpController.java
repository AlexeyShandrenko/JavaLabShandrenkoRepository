package ru.itis.javalab.controllers;

import org.codehaus.plexus.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.services.UsersService;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
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
            usersService.saveUser(map);
            return new ModelAndView("redirect:/sign_in");
        } else {
            return new ModelAndView("redirect:/sign_up");
        }

    }


}
