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
import java.util.HashMap;
import java.util.Optional;

@Controller
public class PlaylistRockController {

    @Autowired
    private TrackService trackService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/playlist_rock", method = RequestMethod.GET)
    public String getPlaylistRockPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "playlist_rock";
    }

    @RequestMapping(value = "/playlist_rock1", method = RequestMethod.POST)
    public ModelAndView addTrack1(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "AC/DC");
            map.put("track_name", "Back In Black");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_rock");
        } else {
            return new ModelAndView("redirect:/playlist_rock");
        }
    }

    @RequestMapping(value = "/playlist_rock2", method = RequestMethod.POST)
    public ModelAndView addTrack2(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Aerosmith");
            map.put("track_name", "Sweet Emotion");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_rock");
        } else {
            return new ModelAndView("redirect:/playlist_rock");
        }
    }

    @RequestMapping(value = "/playlist_rock3", method = RequestMethod.POST)
    public ModelAndView addTrack3(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Fleetwood Mac");
            map.put("track_name", "The Chain");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_rock");
        } else {
            return new ModelAndView("redirect:/playlist_rock");
        }
    }

}
