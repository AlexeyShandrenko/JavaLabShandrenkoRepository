package ru.itis.javalab.services.old;

import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserForm;
import ru.itis.javalab.models.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

//    @Autowired
//    private UsersService usersService;
//
//    @Autowired
//    private BCrypterService bCrypterService;

    @Override
    public void login(UserForm userForm, HttpServletRequest request, HttpServletResponse response, Optional<User> user) {
//        String email = userForm.getEmail().trim();
//        String password = userForm.getPassword().trim();
//        Optional<User> user = usersService.findUserByEmail(email);
//        if (user.isPresent() && bCrypterService.checkPassword(password, user.get().getPassword())) {
            HttpSession session = request.getSession(true);
            session.setAttribute("password", user.get().getPassword());
            session.setAttribute("email", user.get().getEmail());
            session.setAttribute("authenticated", true);
            Cookie cookie = new Cookie("email", userForm.getEmail().trim());
            cookie.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(cookie);
//            return new ModelAndView("redirect:/main_page");
//        } else {
//            return new ModelAndView("redirect:/login");
//        }
    }
}
