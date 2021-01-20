package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Optional;

@Controller
public class EditProfileController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/edit_profile", method = RequestMethod.GET)
    public String getEditProfilePage() {
        return "edit-profile";
    }

    @RequestMapping(value = "/edit_profile", method = RequestMethod.POST)
    public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", user.get().getId());
            map.put("firstname", request.getParameter("firstname"));
            map.put("lastname", request.getParameter("lastname"));
            map.put("age", request.getParameter("age"));
            usersService.updateUser(map);
            return new ModelAndView("redirect:/profile");
        } else {
            return new ModelAndView("redirect:/edit_profile");
        }
    }

}
