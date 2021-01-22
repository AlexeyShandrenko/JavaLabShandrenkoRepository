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
public class PlaylistPopController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "/playlist_pop", method = RequestMethod.GET)
    public String getPlaylistPopPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "playlist_pop";
    }

    @RequestMapping(value = "/playlist_pop1", method = RequestMethod.POST)
    public ModelAndView addTrack4(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Billie Eilish");
            map.put("track_name", "Therefore I Am");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_pop");
        } else {
            return new ModelAndView("redirect:/playlist_pop");
        }
    }

    @RequestMapping(value = "/playlist_pop2", method = RequestMethod.POST)
    public ModelAndView addTrack5(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Ed Sheeran");
            map.put("track_name", "Castle on the Hill");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_pop");
        } else {
            return new ModelAndView("redirect:/playlist_pop");
        }
    }

    @RequestMapping(value = "/playlist_pop3", method = RequestMethod.POST)
    public ModelAndView addTrack6(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");
        if (password != null) {
            Optional<User> user = usersService.findUserByPassword(password);
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id", user.get().getId());
            map.put("artist_name", "Lana Del Rey");
            map.put("track_name", "Young And Beautiful");
            trackService.addTrack(map);
            return new ModelAndView("redirect:/playlist_pop");
        } else {
            return new ModelAndView("redirect:/playlist_pop");
        }
    }

}
