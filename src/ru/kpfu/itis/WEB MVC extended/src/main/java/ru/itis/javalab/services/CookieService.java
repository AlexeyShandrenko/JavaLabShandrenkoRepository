package ru.itis.javalab.services;

import ru.itis.javalab.models.Cookies;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Optional;

public interface CookieService {

    void addCookieToDbByUserId(Long userId, String toString);
    List<Cookies> checkCookiesByID(Long id);
    List<Cookies> checkCookiesByValue(String value);
    Optional<Cookie> findAuthCookie(Cookie[] cookieArray);

}
