package ru.itis.javalab.repositories;

import javax.sql.DataSource;

public class CookieRepositoryImpl implements CookieRepository {

    private static final String SQL_CHECK_COOKIES_BY_ID = "SELECT * FROM cookie WHERE id=?";
    private static final String SQL_CHECK_COOKIES_BY_VALUE = "SELECT * FROM cookie WHERE cookie_value=?";
    private static final String SQL_CHECK_COOKIES_BY_VALUE_AND_ID = "SELECT * FROM cookie WHERE cookie_value=? AND id=?";
    private static final String SQL_SAVE_COOKIES = "INSERT INTO cookie (id, cookie_value) values (?,?)";

    private SimpleJdbcTemplate template;

    public CookieRepositoryImpl(DataSource dataSource) {
        template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void addAuthCookie(Long id, String value) {
        template.checkQuery(SQL_SAVE_COOKIES, id , value);
    }

    @Override
    public Boolean checkCookiesByID(Long id) {
        return template.checkQuery(SQL_CHECK_COOKIES_BY_ID, id);
    }

    @Override
    public Boolean checkCookiesByValue(String value) {
        return template.checkQuery(SQL_CHECK_COOKIES_BY_VALUE, value);
    }

    @Override
    public Boolean checkCookiesByIdAndValue(Long id, String value) {
        return template.checkQuery(SQL_CHECK_COOKIES_BY_VALUE_AND_ID, id, value);
    }
}
