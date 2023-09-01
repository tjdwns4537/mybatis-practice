package kia.com.mybatistest.security.service;

import jakarta.servlet.http.Cookie;
import kia.com.mybatistest.util.AuthConstants;
import kia.com.mybatistest.util.ConvertUtils;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

    public Cookie generateCookie(String rtk) {
        String encoder = ConvertUtils.encoder("Bearer "+ rtk);
        Cookie rtkCookie = new Cookie(AuthConstants.RTK_COOKIE, encoder);
        rtkCookie.setPath("/");
        rtkCookie.setMaxAge(60 * 60 *24 * 2);
        rtkCookie.setHttpOnly(true);
        return rtkCookie;
    }
}
