package kia.com.mybatistest.security.service;

import jakarta.servlet.http.Cookie;
import kia.com.mybatistest.util.AuthConstants;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

    public Cookie generateCookie(String atk) {
        Cookie cookie = new Cookie(AuthConstants.AUTH_COOKIE, "Bearer " + atk);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 *24 * 2);
        cookie.setHttpOnly(true);
        return cookie;
    }
}
