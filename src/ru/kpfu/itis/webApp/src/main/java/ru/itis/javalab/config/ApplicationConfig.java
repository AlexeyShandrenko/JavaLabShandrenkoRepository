package ru.itis.javalab.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.repositories.CookieRepository;
import ru.itis.javalab.repositories.CookieRepositoryImpl;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.repositories.UsersRepositoryJdbcTemplateImpl;
import ru.itis.javalab.services.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.itis.javalab")
@PropertySource("classpath:db.properties")
public class ApplicationConfig {

    @Autowired
    private Environment environment;

    @Bean
    public BCrypterService bCrypterService() {
        return new BCrypterServiceImpl();
    }

    @Bean
    public CookieRepository cookieRepository() {
        return new CookieRepositoryImpl(jdbcTemplate());
    }

    @Bean
    public CookieService cookieService() {
        return new CookieServiceImpl(cookieRepository());
    }
    @Bean
    public UsersService usersService() {
        return new UsersServiceImpl(usersRepository());
    }

     @Bean
     public UsersRepository usersRepository() {
        return new UsersRepositoryJdbcTemplateImpl(jdbcTemplate());
     }

     @Bean
     public NamedParameterJdbcTemplate jdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
     }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(environment.getProperty("db.url"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(environment.getProperty("db.hikari.max-pool-size")));
        hikariConfig.setUsername(environment.getProperty("db.username"));
        hikariConfig.setPassword(environment.getProperty("db.password"));
        hikariConfig.setDriverClassName(environment.getProperty("db.driver-classname"));
        return hikariConfig;
    }

}
