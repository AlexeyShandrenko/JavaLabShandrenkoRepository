package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import javax.jws.soap.SOAPBinding;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    public static final String SQL_SELECT = "SELECT * FROM USERS";
    public static final String SQL_FIND_BY_EMAIL_AND_PASSWORD = "SELECT * FROM USERS WHERE email=? AND password=?";
    public static final String SQL_SAVE_USER = "INSERT INTO USERS (firstname, lastname, email, password) VALUES (?, ?, ?, ?);";
    public static final String SQL_FIND_BY_EMAIL = "SELECT * FROM USERS WHERE email=?";

    private SimpleJdbcTemplate template;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        template = new SimpleJdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = row -> User.builder()
            .id(row.getLong("id"))
            .firstname(row.getString("firstname"))
            .lastname(row.getString("lastname"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();


    @Override
    public Optional<User> findFirstByEmailAndPassword(String email, String pass) {
        List<User> user = template.query(SQL_FIND_BY_EMAIL_AND_PASSWORD, userRowMapper, email, pass);
        return user.isEmpty() ? Optional.empty() : Optional.of(user.get(0));
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        List<User> user = template.query(SQL_FIND_BY_EMAIL, userRowMapper, email);
        return user.isEmpty() ? Optional.empty() : Optional.of(user.get(0));
    }

    @Override
    public List<User> findAll() {
        List<User> user = template.query(SQL_SELECT, userRowMapper);
        return user.isEmpty() ? null : user;
    }

    @Override
    public void save(User entity) {
        template.checkQuery(SQL_SAVE_USER, entity.getFirstname(), entity.getLastname(), entity.getEmail(), entity.getPassword());
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }
}
