package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.javalab.models.Cookies;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookieRepositoryImpl implements CookieRepository {

    private static final String SQL_CHECK_COOKIES_BY_ID = "SELECT * FROM cookie WHERE id= :id";
    private static final String SQL_CHECK_COOKIES_BY_VALUE = "SELECT * FROM cookie WHERE cookie_value= :cookie_value";
    private static final String SQL_CHECK_COOKIES_BY_VALUE_AND_ID = "SELECT * FROM cookie WHERE cookie_value= :cookie_value AND id= :id";
    private static final String SQL_SAVE_COOKIES = "INSERT INTO cookie (id, cookie_value) values (:id, :cookie_value)";

    private NamedParameterJdbcTemplate jdbcTemplate;

//    private RowMapper<Cookies> cookiesRowMapper = (row, i) -> Cookies.builder()
//            .id(row.getLong("id"))
//            .cookie_value(row.getString("cookie_value"))
//            .build();

    private RowMapper<Cookies> cookiesRowMapper = ((row, i) -> Cookies.builder()
    .id(row.getLong("id"))
    .cookie_value(row.getString("cookie_value"))
    .build());

    public CookieRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void addAuthCookie(Long id, String value) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("cookie_value", value);
        jdbcTemplate.update(SQL_SAVE_COOKIES, params);
    }

    @Override
    public List<Cookies> checkCookiesByID(Long id) {
//        return template.query(SQL_CHECK_COOKIES_BY_ID, cookiesRowMapper, id);
        return jdbcTemplate.query(SQL_CHECK_COOKIES_BY_ID, Collections.singletonMap("id", id), cookiesRowMapper);
    }

    @Override
    public List<Cookies> checkCookiesByValue(String value) {
//        return template.query(SQL_CHECK_COOKIES_BY_VALUE, cookiesRowMapper, value);
        return jdbcTemplate.query(SQL_CHECK_COOKIES_BY_VALUE, Collections.singletonMap("cookie_value", value), cookiesRowMapper);
    }

    @Override
    public List<Cookies> checkCookiesByIdAndValue(Long id, String value) {
//        return template.query(SQL_CHECK_COOKIES_BY_VALUE_AND_ID, cookiesRowMapper, id, value);
//        return jdbcTemplate.query(SQL_CHECK_COOKIES_BY_VALUE_AND_ID, Collections.singletonMap("id", id), Collections.singletonMap("cookie_value", value), cookiesRowMapper);
        return null;
    }
}
