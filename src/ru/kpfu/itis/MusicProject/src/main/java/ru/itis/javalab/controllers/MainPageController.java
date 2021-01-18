package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.models.ImageBackground;

import java.io.IOException;

@Controller
public class MainPageController {

    @RequestMapping(value = "/main_page", method = RequestMethod.GET)
    public String getMainPage(Model model, ImageBackground imageBackground) throws IOException {
        model.addAttribute("image", imageBackground.getUrl());
        return "index-reg";
    }

}
