package ru.itis.javalab.filters;

import ru.itis.javalab.services.CookieService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/login")
public class AuthFilter implements Filter {

//    private CookieService cookieService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        ServletContext context = filterConfig.getServletContext();
//        cookieService = (CookieService) context.getAttribute("cookieService");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        boolean isLogin = req.getRequestURI().equals("/login");
        boolean isProfile = req.getRequestURI().equals("/users");

        HttpSession session = req.getSession(false);
        Boolean isSessionExists = session != null;
        Boolean isAuth = false;
        String isAuthentificated;

        if (isSessionExists) {
            isAuthentificated = (String) session.getAttribute("password");
            if (isAuthentificated != null) {
                isAuth = true;
            }
        }

        if (isLogin) {
            if (isAuth) {
                res.sendRedirect("/users");
            } else {
                filterChain.doFilter(req, res);
            }
        }

        if (isProfile) {
            if (isAuth) {
                filterChain.doFilter(req, res);
            } else {
                res.sendRedirect("/login");
            }
        }

//        if (isLogin) {
//            Cookie[] cookies = req.getCookies();
//            Optional<Cookie> authCookie = cookieService.findAuthCookie(cookies);
//            Boolean cookieInDataBase;
//            if (authCookie.isPresent()) {
//                cookieInDataBase = cookieService.checkCookiesByValue(authCookie.get().getValue());
//                if (cookieInDataBase) {
//                    res.sendRedirect("/users");
//                } else {
//                    filterChain.doFilter(req, res);
//                }
//            } else {
//                filterChain.doFilter(req, res);
//            }
//        } else if (isProfile) {
//            Cookie[] cookies = req.getCookies();
//            Optional<Cookie> authCookie = cookieService.findAuthCookie(cookies);
//            Boolean cookieInDataBase;
//            if (authCookie.isPresent()) {
//                cookieInDataBase = cookieService.checkCookiesByValue(authCookie.get().getValue());
//                if (cookieInDataBase) {
//                    filterChain.doFilter(req, res);
//                } else {
//                    res.sendRedirect("/login");
//                }
//            }
//        } else {
//            res.sendRedirect("/login");
//        }
    }

    @Override
    public void destroy() {

    }
}
