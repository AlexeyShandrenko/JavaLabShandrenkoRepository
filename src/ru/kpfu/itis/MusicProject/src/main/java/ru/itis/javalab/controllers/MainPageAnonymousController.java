package ru.itis.javalab.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.models.ImageBackground;

import java.io.IOException;

@Controller
@Profile("master")
public class MainPageAnonymousController {

    @RequestMapping(value = "/main_page_anonymous", method = RequestMethod.GET)
    public String getMainPage(Model model, ImageBackground imageBackground) throws IOException {
        model.addAttribute("image", imageBackground.getUrl());
        return "anonymous";
    }

}
