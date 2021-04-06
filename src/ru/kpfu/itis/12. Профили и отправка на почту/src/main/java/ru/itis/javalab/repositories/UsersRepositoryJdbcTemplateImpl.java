package ru.itis.javalab.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;

import java.util.*;

@Repository
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_FIND_ONE_BY_EMAIL = "select * from users where email = :email limit 1";

    //language=SQL
    private static final String SQL_FIND_USER_BY_PASSWORD = "select * from users where password = :password limit 1";

    //language=SQL
    private static final String SQL_FIND_BY_EMAIL_AND_PASSWORD = "select * from users where email = :email and password = :password limit 1";

    //language=SQL
    private static final String SQL_INSERT = "insert into users (firstname, lastname, email, password, age, confirm_code) " +
            "values (:firstname, :lastname, :email, :password, :age, :confirm_code)";

    //language=SQL
    private static final String SQL_UPDATE_USER = "update users set firstname = :firstname, lastname = :lastname, age = :age where id = :id";

    //language=SQL
//    private static final String SQL_INSERT_USER = "insert into users (firstname, lastname) values (:firstname, :lastname)";

    //language=SQL
    private static final String SQL_SELECT = "select * from users";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from users where id = :id limit 1";

    //language=SQL
    private static final String SQL_SELECT_ALL_WITH_PAGES = "select * from users order by id limit :limit offset :offset;";

    private NamedParameterJdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
            .id(row.getLong("id"))
            .firstname(row.getString("firstname"))
            .lastname(row.getString("lastname"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .age(row.getString("age"))
            .confirm_code(row.getString("confirm_code"))
            .build();

    public UsersRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<User> findFirstByEmailAndPassword(String email, String pass) {
        return Optional.empty();
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
    public Optional<User> findUserByPassword(String password) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_USER_BY_PASSWORD,
                    Collections.singletonMap("password", password),
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
        params.put("email", entity.getEmail());
        params.put("password", entity.getPassword());
        params.put("age", entity.getAge());
        params.put("confirm_code", entity.getConfirm_code());
        jdbcTemplate.update(SQL_INSERT, params);
    }

    @Override
    public void update(User entity, Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstname", entity.getFirstname());
        params.put("lastname", entity.getLastname());
        params.put("age", entity.getAge());
        jdbcTemplate.update("update users set firstname = :firstname, lastname = :lastname, age = :age where id =" + id, params);
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
