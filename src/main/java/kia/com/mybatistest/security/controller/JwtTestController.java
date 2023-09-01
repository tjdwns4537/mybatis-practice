package kia.com.mybatistest.security.controller;

import io.jsonwebtoken.security.WeakKeyException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kia.com.mybatistest.model.dto.LoginUserDto;
import kia.com.mybatistest.response.TokenResponse;
import kia.com.mybatistest.response.TokenResponseCode;
import kia.com.mybatistest.security.service.CookieService;
import kia.com.mybatistest.security.service.TokenService;
import kia.com.mybatistest.util.AuthConstants;
import kia.com.mybatistest.util.ConvertUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class JwtTestController {

    private final TokenService tokenService;
    private final CookieService cookieService;

    @PostMapping("/generateToken")
    public ResponseEntity<TokenResponse> generateToken(HttpServletResponse httpServletResponse, @RequestBody LoginUserDto loginUserDto) {
        try {
            String atk = tokenService.generateJwtAccessToken(loginUserDto);
            String rtk = tokenService.generateJwtRefreshToken(loginUserDto);

            loginUserDto.setRefreshToken(rtk);

            log.info("토큰 발급:\nATK {}\nRTK {}", atk, rtk);

            Cookie rtkCookie = cookieService.generateCookie(rtk); // cookie 설정
            httpServletResponse.addCookie(rtkCookie);

            if (atk.isEmpty()) {
                TokenResponse tokenResponse = TokenResponse.builder()
                        .code(TokenResponseCode.NOT_FOUND.getCode())
                        .status(TokenResponseCode.NOT_FOUND.getHttpStatus())
                        .message(TokenResponseCode.NOT_FOUND.getMessage())
                        .data(atk).build();
                return new ResponseEntity<>(tokenResponse, HttpStatus.NOT_FOUND);
            }

            TokenResponse tokenResponse = TokenResponse.builder()
                    .code(TokenResponseCode.OK.getCode())
                    .status(TokenResponseCode.OK.getHttpStatus())
                    .message(TokenResponseCode.OK.getMessage())
                    .data(atk).build();

            return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
        } catch (WeakKeyException e) {
            TokenResponse tokenResponse = TokenResponse.builder()
                    .code(TokenResponseCode.INTERNAL_SERVER_ERROR.getCode())
                    .status(TokenResponseCode.INTERNAL_SERVER_ERROR.getHttpStatus())
                    .message(TokenResponseCode.INTERNAL_SERVER_ERROR.getMessage())
                    .data(e.getMessage()).build();
            return new ResponseEntity<>(tokenResponse, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/dataByToken")
    public ResponseEntity<TokenResponse> showTokenData(HttpServletRequest req) {
        String token = Arrays.stream(req.getCookies())
                .filter(c -> c.getName().equals(AuthConstants.RTK_COOKIE))
                .findFirst().map(Cookie::getValue)
                .orElse(null);

        String rtk = ConvertUtils.decoder(token);

        log.info("show token : {}", rtk);
        String tokenData = tokenService.getTokenData(rtk);
        String userEmail = tokenService.getUserEmailFromToken(tokenData);

        TokenResponse tokenResponse = TokenResponse.builder()
                .code(TokenResponseCode.OK.getCode())
                .message(TokenResponseCode.OK.getMessage())
                .status(TokenResponseCode.OK.getHttpStatus())
                .data(userEmail).build();

        return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
    }
}
