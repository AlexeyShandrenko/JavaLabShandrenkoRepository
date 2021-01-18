package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PlaylistPopController {

    @RequestMapping(value = "/playlist_pop", method = RequestMethod.GET)
    public String getPlaylistPopPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "playlist_pop";
    }

}
