package ru.itis.javalab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.javalab.models.ImageBackground;

import java.io.IOException;

@Controller
public class FAQController {

    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public String getFAQPage() throws IOException {
        return "FAQ-reg";
    }

}
