package ru.itis.javalab.repositories.old;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.old.UsersRepository;

import java.util.*;

@Repository
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_FIND_USER_BY_EMAIL = "select * from users where email = :email";

    //language=SQL
    private static final String SQL_FIND_USER_BY_PASSWORD = "select * from users where password = :password";

    //language=SQL
    private static final String SQL_FIND_USER_BY_EMAIL_AND_PASSWORD = "select * from users where email = :email and password = :password";

    //language=SQL
    private static final String SQL_FIND_ALL_USERS = "select * from users";

    //language=SQL
    private static final String SQL_FIND_ALL_USERS_PAGES = "select * from users order by user_id limit :limit offset :offset";

    //language=SQL
    private static final String SQL_SAVE_USER = "insert into users(firstname, lastname, age, email, password, city, phone, confirm_code) values (:firstname, :lastname, :age, :email, :password, :city, :phone, :confirm_code)";

    //language=SQL
    private static final String SQL_DELETE_USER_BY_ID = "delete from users where user_id = :user_id";

    //language=SQL
    private static final String SQL_FIND_USER_BY_ID = "select * from users where user_id = :user_id";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
            .user_id(row.getLong("user_id"))
            .firstname(row.getString("firstname"))
            .lastname(row.getString("lastname"))
            .age(row.getInt("age"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .city(row.getString("city"))
            .phone(row.getString("phone"))
            .confirm_code(row.getString("confirm_code"))
            .build();

    @Override
    public List<User> findFirstByEmailAndPassword(String email, String pass) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", pass);
        return jdbcTemplate.query(SQL_FIND_USER_BY_EMAIL_AND_PASSWORD, params, userRowMapper);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_USER_BY_EMAIL,
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
        return jdbcTemplate.query(SQL_FIND_ALL_USERS, userRowMapper);
    }

    @Override
    public List<User> findAll(int page, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", size);
        params.put("offset", page * size);
        return jdbcTemplate.query(SQL_FIND_ALL_USERS_PAGES, params, userRowMapper);
    }

    @Override
    public void save(User entity) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstname", entity.getFirstname());
        params.put("lastname", entity.getLastname());
        params.put("age", entity.getAge());
        params.put("email", entity.getEmail());
        params.put("password", entity.getPassword());
        params.put("city", entity.getCity());
        params.put("phone", entity.getPhone());
        params.put("confirm_code", entity.getConfirm_code());
        jdbcTemplate.update(SQL_SAVE_USER, params);
    }

    @Override
    public void update(User entity, Long aLong) {

    }

    @Override
    public void delete(User entity, Long aLong) {
        try {
            Optional.of(jdbcTemplate.queryForObject(SQL_DELETE_USER_BY_ID,
                    Collections.singletonMap("user_id", aLong), userRowMapper));
        } catch (EmptyResultDataAccessException e) {
            Optional.empty();
        }
    }

    @Override
    public Optional<User> findById(Long aLong) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_USER_BY_ID,
                    Collections.singletonMap("user_id", aLong),
                    userRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
