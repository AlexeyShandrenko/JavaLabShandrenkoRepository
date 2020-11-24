package ru.itis.javalab.servlets;

import ru.itis.javalab.models.User;
import ru.itis.javalab.services.CookieService;
import ru.itis.javalab.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class LoginServlet extends HttpServlet {
    private CookieService cookieService;
    private UsersService usersService;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
        cookieService = (CookieService) context.getAttribute("cookieService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/front/login.html").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        Optional<User> user = usersService.findUserByEmailAndPassword(email, password);
        if (user.isPresent()) {
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
