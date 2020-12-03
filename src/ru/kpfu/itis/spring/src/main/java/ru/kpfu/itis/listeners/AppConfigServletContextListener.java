package ru.kpfu.itis.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
//import ru.kpfu.itis.repositories.CookieRepository;
//import ru.kpfu.itis.repositories.CookieRepositoryImpl;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.repositories.UsersRepository;
import ru.kpfu.itis.repositories.UsersRepositoryJdbcTemplateImpl;
import ru.kpfu.itis.services.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class AppConfigServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        Properties properties = new Properties();
        try {
            properties.load(servletContext.getResourceAsStream("/WEB-INF/properties/db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(properties.getProperty("db.url"));
        hikariConfig.setDriverClassName(properties.getProperty("db.driver-classname"));
        hikariConfig.setUsername(properties.getProperty("db.username"));
        hikariConfig.setPassword(properties.getProperty("db.password"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikari.max-pool-size")));
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        servletContext.setAttribute("dataSource", dataSource);

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(jdbcTemplate);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        MailsService mailsService = new MailsServiceMockImpl();

        UsersService usersService = new UsersServiceImpl(usersRepository, passwordEncoder, mailsService);
        servletContext.setAttribute("usersService", usersService);

        ObjectMapper objectMapper = new ObjectMapper();
        servletContext.setAttribute("objectMapper", objectMapper);


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
