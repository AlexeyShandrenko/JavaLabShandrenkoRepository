package ru.itis.javalab.servlets;

import org.springframework.context.ApplicationContext;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.BCrypterService;
import ru.itis.javalab.services.BCrypterServiceImpl;
import ru.itis.javalab.services.CookieService;
import ru.itis.javalab.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class LoginServlet extends HttpServlet {
    private CookieService cookieService;
    private UsersService usersService;
    private BCrypterService bCrypterService;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) context.getAttribute("applicationContext");
        usersService = applicationContext.getBean(UsersService.class);
        cookieService = applicationContext.getBean(CookieService.class);
        bCrypterService = applicationContext.getBean(BCrypterServiceImpl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/front/login.html").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        Optional<User> user = usersService.findUserByEmail(email);
        if (user.isPresent() && bCrypterService.checkPassword(password, user.get().getPassword())) {
            HttpSession session = req.getSession(true);
            session.setAttribute("password", user.get().getPassword());
            Long id = user.get().getId();
            UUID uuid = UUID.randomUUID();
            cookieService.addCookieToDbByUserId(id, uuid.toString());
            Cookie cookie = new Cookie("AUTH", uuid.toString());
            resp.addCookie(cookie);
            resp.sendRedirect("/users");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
