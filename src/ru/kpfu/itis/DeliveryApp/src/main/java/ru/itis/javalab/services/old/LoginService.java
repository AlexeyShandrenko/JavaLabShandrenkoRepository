package ru.itis.javalab.services.old;

import org.springframework.web.servlet.ModelAndView;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public interface LoginService {
    void login(UserForm userForm, HttpServletRequest request, HttpServletResponse response, Optional<User> user);
}
