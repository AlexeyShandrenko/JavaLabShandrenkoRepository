package ru.itis.javalab.services;

import ru.itis.javalab.repositories.CookieRepository;

import javax.servlet.http.Cookie;
import java.util.Optional;

public class CookieServiceImpl implements CookieService {

    CookieRepository cookieRepository;

    public CookieServiceImpl(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    @Override
    public void addCookieToDbByUserId(Long id, String value) {
        cookieRepository.addAuthCookie(id, value);
    }

    @Override
    public Boolean checkCookiesByID(Long id) {
        return cookieRepository.checkCookiesByID(id);
    }

    @Override
    public Boolean checkCookiesByValue(String value) {
        return cookieRepository.checkCookiesByValue(value);
    }

    @Override
    public Optional<Cookie> findAuthCookie(Cookie[] cookieArray) {
        for (Cookie cookie : cookieArray) {
            if (cookie.getName().equals("AUTH")) {
                return Optional.of(cookie);
            }
        }
        return Optional.empty();
    }
}
