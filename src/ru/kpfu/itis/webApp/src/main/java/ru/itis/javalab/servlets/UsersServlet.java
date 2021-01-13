package ru.itis.javalab.servlets;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.models.User;
import ru.itis.javalab.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.itis.javalab.dto.UserDto.from;

public class UsersServlet extends HttpServlet {

    private UsersService usersService;
//    private PasswordEncoder passwordEncoder;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("applicationContext");
        usersService = applicationContext.getBean(UsersService.class);
//        passwordEncoder = applicationContext.getBean(BCryptPasswordEncoder.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateLoader(new FileTemplateLoader(new File("D:\\Repository\\JavaLab\\JavaLabShandrenkoRepository\\src\\ru\\kpfu\\itis\\webApp\\src\\main\\webapp\\free")));
        Template template = configuration.getTemplate("users.ftlh");

        Cookie [] cookies = request.getCookies();
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("color")) {
                cookie = c;
            }
        }

        List<User> users = usersService.getAllUser();
//        for (int i = 0; i < users.size(); i++) {
//            from(users.get(i));
//        }

//        List<User> users = new ArrayList<>();
//        users.add((User.builder()
//                .id(1L)
//                .firstname("alex")
//                .lastname("bandit")
//                .email("java@mail.ru")
//                .password("123456")
//                .build()));
//
//        users.add(User.builder()
//                .id(2L)
//                .firstname("as")
//                .lastname("sndit")
//                .email("java@mail.ru")
//                .password("12s456")
//                .build());



//
//        request.setAttribute("userForJsp", users);
        request.setAttribute("color", cookie);

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("color", cookie);
        attributes.put("users", users);
        System.out.println(attributes);


        FileWriter fileWriter = new FileWriter("output.html");
        try {
            template.process(attributes, fileWriter);
        } catch (TemplateException e) {
            throw new IllegalArgumentException(e);
        }
        request.getRequestDispatcher("free/users.ftlh").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String password =req.getParameter("password");
//        String hashPassword = passwordEncoder.encode(password);
//        System.out.println(hashPassword);
//        System.out.println(passwordEncoder.matches("qwerty007", hashPassword));
        String color = req.getParameter("color");
        Cookie cookie = new Cookie("color", color);
        cookie.setMaxAge(60 * 60 * 24 * 365);
        resp.addCookie(cookie);
        resp.sendRedirect("/users");
    }
}
