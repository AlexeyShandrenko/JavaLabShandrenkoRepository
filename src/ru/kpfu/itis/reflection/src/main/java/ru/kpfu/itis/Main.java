package ru.kpfu.itis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.lang.reflect.Field;

public class Main {

    private String kek;
    private String kek1;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/Javalab_2020");
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("Pkm17k17tb");
        hikariConfig.setMaximumPoolSize(20);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        Class<?> users = Class.forName("ru.kpfu.itis.User");
        EntityManager entityManager = new EntityManager(dataSource);
//        entityManager.createTable("testTable", users);
        User user1 = new User("vasya", "pupkin", true, 123L);
//        entityManager.save("testTable", user1);
        entityManager.findById("testTable", users, Long.class, 123L);


//

    }
}
