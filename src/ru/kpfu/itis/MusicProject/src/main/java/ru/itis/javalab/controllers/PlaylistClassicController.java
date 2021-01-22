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
public class PlaylistClassicController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "/playlist_classic", method = RequestMethod.GET)
    public String getPlaylistClassicPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "playlist_classic";
    }

    @RequestMapping(value = "/playlist_classic1", method = RequestMethod.POST)
    public ModelAndView addTrack7(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Claude Debussy");
            map.put("track_name", "Clair De Lune");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_classic");
        } else {
            return new ModelAndView("redirect:/playlist_classic");
        }
    }

    @RequestMapping(value = "/playlist_classic2", method = RequestMethod.POST)
    public ModelAndView addTrack8(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Ludvig Van Beethoven");
            map.put("track_name", "Moonlight Sonata");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_classic");
        } else {
            return new ModelAndView("redirect:/playlist_classic");
        }
    }

    @RequestMapping(value = "/playlist_classic3", method = RequestMethod.POST)
    public ModelAndView addTrack9(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Richard Wagner");
            map.put("track_name", "The Valkerie");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_classic");
        } else {
            return new ModelAndView("redirect:/playlist_classic");
        }
    }

}
