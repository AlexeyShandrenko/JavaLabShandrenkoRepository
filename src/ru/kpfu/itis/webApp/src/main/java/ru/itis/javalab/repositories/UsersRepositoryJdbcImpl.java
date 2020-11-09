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

    //language=SQL
    private static final String SQL_SELECT_BY_AGE = "select * from users where age = ?";
    //language=SQL
    private static final String SQL_SELECT = "select * from users";
    //language=SQL
    private static final String SQL_SELECT_FIRST_BY_FIRSTNAME_AND_LASTNAME = "select * from users where firstname=? and lastname=?";
    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from users where id=?";

    private SimpleJdbcTemplate template;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        template = new SimpleJdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = row -> User.builder()
            .id(row.getLong("id"))
            .firstname(row.getString("firstname"))
            .lastname(row.getString("lastname"))
            .age(row.getInt("age"))
            .build();

    @Override
    public List<User> findAllByAge(Integer age) {
        List<User> user = template.query(SQL_SELECT_BY_AGE, userRowMapper, age);
        return user.isEmpty() ? null : user;
    }

    @Override
    public Optional<User> findFirstByFirstnameAndLastname(String firstname, String lastname) {
        List<User> user = template.query(SQL_SELECT_FIRST_BY_FIRSTNAME_AND_LASTNAME, userRowMapper, firstname, lastname);
        return user.isEmpty() ? Optional.empty() : Optional.of(user.get(0));
    }

    @Override
    public List<User> findAll() {
        List<User> user = template.query(SQL_SELECT, userRowMapper);
        return user.isEmpty() ? null : user;
    }

    @Override
    public Optional<User> findById(Long id) {
        List<User> user = template.query(SQL_SELECT_BY_ID, userRowMapper, id);
        return user.isEmpty() ? Optional.empty() : Optional.of(user.get(0));
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(User entity) {

    }
}
