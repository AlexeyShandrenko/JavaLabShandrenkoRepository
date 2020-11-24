package ru.itis.javalab.repositories;

public interface CookieRepository {

    void addAuthCookie(Long id, String value);
    Boolean checkCookiesByID(Long id);
    Boolean checkCookiesByValue(String value);
    Boolean checkCookiesByIdAndValue(Long id, String value);

}
