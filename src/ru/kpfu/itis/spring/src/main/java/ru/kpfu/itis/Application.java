package ru.kpfu.itis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.front.Front;
import ru.kpfu.itis.front.FrontImpl;
import ru.kpfu.itis.repositories.UsersRepository;
import ru.kpfu.itis.repositories.UsersRepositoryJdbcTemplateImpl;
import ru.kpfu.itis.services.MailsService;
import ru.kpfu.itis.services.MailsServiceMockImpl;
import ru.kpfu.itis.services.UsersService;
import ru.kpfu.itis.services.UsersServiceImpl;

import javax.sql.DataSource;

public class Application {
    public static void main(String[] args) {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:postgresql://localhost:5432/Javalab_2020");
//        config.setDriverClassName("org.postgresql.Driver");
//        config.setUsername("postgres");
//        config.setPassword("Pkm17k17tb");
//        config.setMaximumPoolSize(20);
//        HikariDataSource dataSource = new HikariDataSource(config);
//
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(namedParameterJdbcTemplate);
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        MailsService mailsService = new MailsServiceMockImpl();
//        UsersService usersService = new UsersServiceImpl(usersRepository, passwordEncoder, mailsService);
//        Front front = new FrontImpl(usersService);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Front front = context.getBean("front", Front.class);
        front.run();
    }
}
