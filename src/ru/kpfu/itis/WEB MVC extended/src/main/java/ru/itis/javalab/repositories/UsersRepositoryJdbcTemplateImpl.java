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
import java.util.*;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_FIND_ONE_BY_EMAIL = "select * from users where email = :email limit 1";

    //language=SQL
    private static final String SQL_FIND_BY_EMAIL_AND_PASSWORD = "select * from users where email = :email and password = :password limit 1";

    //language=SQL
    private static final String SQL_INSERT = "insert into users (firstname, lastname, email, password) " +
            "values (:firstname, :lastname, :email, :password)";

    //language=SQL
    private static final String SQL_INSERT_USER = "insert into users (firstname, lastname) values (:firstname, :lastname)";

    //language=SQL
    private static final String SQL_SELECT = "select * from users";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from users where id = :id limit 1";

    //language=SQL
    private static final String SQL_SELECT_ALL_WITH_PAGES = "select * from users order by id limit :limit offset :offset;";

    //    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcTemplate;

//    public static final String SQL_SELECT = "SELECT * FROM USERS";
//    public static final String SQL_FIND_BY_EMAIL_AND_PASSWORD = "";
//    public static final String SQL_INSERT = "INSERT INTO USERS (firstname, lastname, email, password) values (:email, :firstName, :lastName, :hashPassword)";
//    public static final String SQL_FIND_BY_EMAIL = "select * from account where email = :email limit 1";
//    public static final String SQL_SELECT_ALL_WITH_PAGES = "SELECT * FROM USERS ORDER BY id LIMIT :limit OFFSET :offset;";

    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
            .id(row.getLong("id"))
            .firstname(row.getString("firstname"))
            .lastname(row.getString("lastname"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();

    public UsersRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<User> findFirstByEmailAndPassword(String email, String password) {
//        try {
//            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL_AND_PASSWORD,
//                    Collections.singletonMap("email", email), Collections.singletonMap("password", password),
//                    userRowMapper));
//        } catch (EmptyResultDataAccessException e) {
//            return Optional.empty();
//        }
        return null;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_ONE_BY_EMAIL,
                    Collections.singletonMap("email", email),
                    userRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
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
        return jdbcTemplate.query(SQL_SELECT_ALL_WITH_PAGES, params, userRowMapper);
    }

    @Override
    public void save(User entity) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstname", entity.getFirstname());
        params.put("lastname", entity.getLastname());
//        params.put("email", entity.getEmail());
//        params.put("password", entity.getPassword());
        jdbcTemplate.update(SQL_INSERT_USER, params);
        // TODO: вставка id после insert-а
        // entity.setId(сгенерированный в базе id)

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, Collections.singletonMap("id", id), userRowMapper);
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }

        return Optional.ofNullable(user);
    }
}
