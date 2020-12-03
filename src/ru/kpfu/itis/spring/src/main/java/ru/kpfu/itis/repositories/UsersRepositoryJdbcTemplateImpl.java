package ru.kpfu.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.kpfu.itis.models.User;

import javax.jws.soap.SOAPBinding;
import java.util.*;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_FIND_ONE_BY_EMAIL = "select * from account where email = :email limit 1";

    //language=SQL
    private static final String SQL_INSERT = "insert into account(email, first_name, last_name, hash_password) " +
            "values (:email, :firstName, :lastName, :hashPassword)";

    //language=SQL
    private static final String SQL_SELECT = "select * from account";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from account where id = :id limit 1";

    //language=SQL
    private static final String SQL_SELECT_ALL_WITH_PAGES = "select * from account order by id limit :limit offset :offset;";

    //    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.jdbcTemplate = template;
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    private RowMapper<User> userRowMapper = (row, rowNumber) ->
            User.builder()
                    .id(row.getLong("id"))
                    .firstName(row.getString("first_name"))
                    .lastName(row.getString("last_name"))
                    .email(row.getString("email"))
                    .hashPassword(row.getString("hash_password"))
                    .build();


    @Override
    public Optional<User> findOneByEmail(String email) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_FIND_ONE_BY_EMAIL,
                    Collections.singletonMap("email", email),
                    userRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    @Override
    public List<User> findAllByAge(Integer age) {
        return null;
    }

    @Override
    public void save(User entity) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", entity.getEmail());
        params.put("firstName", entity.getFirstName());
        params.put("lastName", entity.getLastName());
        params.put("hashPassword", entity.getHashPassword());
        jdbcTemplate.update(SQL_INSERT, params);
        // TODO: вставка id после insert-а
        // entity.setId(сгенерированный в базе id)

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, Collections.singletonMap("id", aLong), userRowMapper);
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
        return jdbcTemplate.query(SQL_SELECT_ALL_WITH_PAGES, params, userRowMapper);
    }
}
