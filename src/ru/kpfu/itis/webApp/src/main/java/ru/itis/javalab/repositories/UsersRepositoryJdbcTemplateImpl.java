package ru.itis.javalab.repositories;

import com.sun.rowset.internal.Row;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static final String SQL_SELECT = "SELECT * FROM USERS";
    public static final String SQL_FIND_BY_EMAIL_AND_PASSWORD = "SELECT * FROM USERS WHERE email=? AND password=?";
//    public static final String SQL_SAVE_USER = "INSERT INTO USERS (firstname, lastname, email, password) V
    public static final String SQL_FIND_BY_EMAIL = "SELECT * FROM USERS WHERE email=?";
    public static final String SQL_SELECT_ALL_WITH_PAGES = "SELECT * FROM USERS ORDER BY id LIMIT :limit OFFSET :offset;";

    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
            .id(row.getLong("id"))
            .firstname(row.getString("firstname"))
            .lastname(row.getString("lastname"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findFirstByEmailAndPassword(String email, String pass) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL_AND_PASSWORD, userRowMapper, email, pass);
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, userRowMapper, email);
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT, userRowMapper);
    }

    @Override
    public List<User> findAll(int page, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", size);
        params.put("offset", page * size);
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_WITH_PAGES, params, userRowMapper);
    }

    @Override
    public void save(User entity) {
        //TODO
        System.out.println(entity);
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }
}
