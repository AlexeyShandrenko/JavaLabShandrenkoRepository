package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PlaylistClassicController {

    @RequestMapping(value = "/playlist_classic", method = RequestMethod.GET)
    public String getPlaylistClassicPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "playlist_classic";
    }

}
