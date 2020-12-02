package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.javalab.models.Cookies;

import javax.sql.DataSource;
import java.util.List;

public class CookieRepositoryImpl implements CookieRepository {

    private static final String SQL_CHECK_COOKIES_BY_ID = "SELECT * FROM cookie WHERE id=?";
    private static final String SQL_CHECK_COOKIES_BY_VALUE = "SELECT * FROM cookie WHERE cookie_value=?";
    private static final String SQL_CHECK_COOKIES_BY_VALUE_AND_ID = "SELECT * FROM cookie WHERE cookie_value=? AND id=?";
    private static final String SQL_SAVE_COOKIES = "INSERT INTO cookie (id, cookie_value) values (?,?)";

    private RowMapper<Cookies> cookiesRowMapper = (row, i) -> Cookies.builder()
            .id(row.getLong("id"))
            .cookie_value(row.getString("cookie_value"))
            .build();

    private JdbcTemplate template;

    public CookieRepositoryImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public void addAuthCookie(Long id, String value) {
        template.query(SQL_SAVE_COOKIES, cookiesRowMapper, id, value);
    }

    @Override
    public List<Cookies> checkCookiesByID(Long id) {
        return template.query(SQL_CHECK_COOKIES_BY_ID, cookiesRowMapper, id);
    }

    @Override
    public List<Cookies> checkCookiesByValue(String value) {
        return template.query(SQL_CHECK_COOKIES_BY_VALUE, cookiesRowMapper, value);
    }

    @Override
    public List<Cookies> checkCookiesByIdAndValue(Long id, String value) {
        return template.query(SQL_CHECK_COOKIES_BY_VALUE_AND_ID, cookiesRowMapper, id, value);
    }
}
