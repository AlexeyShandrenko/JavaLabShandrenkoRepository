package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.services.UsersService;

import java.io.IOException;

@Controller
public class CommunityController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/community", method = RequestMethod.GET)
    public ModelAndView getCommunityPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("community");
        modelAndView.addObject("users", usersService.getAllUser());
        return modelAndView;
    }

}
