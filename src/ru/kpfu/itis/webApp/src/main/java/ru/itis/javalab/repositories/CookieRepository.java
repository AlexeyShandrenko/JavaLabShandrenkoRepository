package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Cookies;

import java.util.List;

public interface CookieRepository {

    void addAuthCookie(Long id, String value);
    List<Cookies> checkCookiesByID(Long id);
    List<Cookies> checkCookiesByValue(String value);
    List<Cookies> checkCookiesByIdAndValue(Long id, String value);

}
