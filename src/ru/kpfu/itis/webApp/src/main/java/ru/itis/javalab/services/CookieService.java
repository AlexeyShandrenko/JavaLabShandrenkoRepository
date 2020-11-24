package ru.itis.javalab.services;

import javax.servlet.http.Cookie;
import java.util.Optional;

public interface CookieService {

    void addCookieToDbByUserId(Long userId, String toString);
    Boolean checkCookiesByID(Long id);
    Boolean checkCookiesByValue(String value);
    Optional<Cookie> findAuthCookie(Cookie[] cookieArray);

}
