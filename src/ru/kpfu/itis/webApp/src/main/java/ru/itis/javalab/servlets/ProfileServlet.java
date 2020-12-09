package ru.itis.javalab.servlets;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.repositories.UsersRepositoryJdbcTemplateImpl;
import ru.itis.javalab.repositories.UsersRepositoryJdbcTemplateImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private UsersRepository usersRepository;
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        usersRepository = (UsersRepository) context.getAttribute("userRepository");
        dataSource = (DataSource) context.getAttribute("dataSource");
        jdbcTemplate = (NamedParameterJdbcTemplate) context.getAttribute("jdbcTemplate");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user_email = (String) session.getAttribute("user_email");
        if (user_email != null) {
            UsersRepositoryJdbcTemplateImpl dui = new UsersRepositoryJdbcTemplateImpl(jdbcTemplate);
            Optional<User> user = dui.findUserByEmail(user_email);
            req.setAttribute("user_name", user);
                    req.getRequestDispatcher("/front/profile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/main_page");
        }

    }
}
