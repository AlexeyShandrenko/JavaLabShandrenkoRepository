package ru.itis.javalab.servlets;

import ru.itis.javalab.services.CookieService;
import ru.itis.javalab.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class SignUpServlet extends HttpServlet {

    private UsersService usersService;
    private CookieService cookieService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
        cookieService = (CookieService) servletContext.getAttribute("cookieService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/front/sign_up.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, String> map = new HashMap<>();
        String password  = request.getParameter("password");
        String password_repeat = request.getParameter("password_repeat");
        if (password.equals(password_repeat)) {
            map.put("firstname", request.getParameter("firstname"));
            map.put("lastname", request.getParameter("lastname"));
            map.put("email", request.getParameter("email"));
            map.put("password", request.getParameter("password"));
            usersService.saveUser(map);
            response.sendRedirect("/login");
        } else {
            response.sendRedirect("/sign_up");
        }
    }

}
