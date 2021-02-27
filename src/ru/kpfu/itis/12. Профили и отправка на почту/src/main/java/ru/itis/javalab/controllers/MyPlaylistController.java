package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.TrackService;
import ru.itis.javalab.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MyPlaylistController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "/my_playlist", method = RequestMethod.GET)
    public ModelAndView getMyPlaylistPage(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            model.setViewName("my_playlist");
            Optional<User> user = usersService.findUserByPassword(password);
            model.addObject("tracks", trackService.findById(user.get().getId()));
            return model;
        } else {
            return new ModelAndView("redirect:/my_playlist");
        }
    }

}
