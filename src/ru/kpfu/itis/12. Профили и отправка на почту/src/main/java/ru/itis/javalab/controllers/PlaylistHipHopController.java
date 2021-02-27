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
public class PlaylistHipHopController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "/playlist_hiphop", method = RequestMethod.GET)
    public String getPlaylistHipHopPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "playlist_hip-hop";
    }

    @RequestMapping(value = "/playlist_hiphop1", method = RequestMethod.POST)
    public ModelAndView addTrack10(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Travis Scott");
            map.put("track_name", "SICKO MODE");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_hiphop");
        } else {
            return new ModelAndView("redirect:/playlist_hiphop");
        }
    }

    @RequestMapping(value = "/playlist_hiphop2", method = RequestMethod.POST)
    public ModelAndView addTrack11(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Post Malone");
            map.put("track_name", "Sunflower");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_hiphop");
        } else {
            return new ModelAndView("redirect:/playlist_hiphop");
        }
    }

    @RequestMapping(value = "/playlist_hiphop3", method = RequestMethod.POST)
    public ModelAndView addTrack12(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Young Thug");
            map.put("track_name", "Hot");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_hiphop");
        } else {
            return new ModelAndView("redirect:/playlist_hiphop");
        }
    }

}
