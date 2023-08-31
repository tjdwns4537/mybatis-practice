package kia.com.mybatistest.security.controller;

import io.jsonwebtoken.security.WeakKeyException;
import jakarta.servlet.http.HttpServletRequest;
import kia.com.mybatistest.model.dto.LoginUserDto;
import kia.com.mybatistest.response.TokenResponse;
import kia.com.mybatistest.response.TokenResponseCode;
import kia.com.mybatistest.security.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class JwtTestController {

    private final TokenUtils tokenUtils;

    @PostMapping("/generateToken")
    public ResponseEntity<TokenResponse> generateToken(@RequestBody LoginUserDto loginUserDto) {
        try {
            String atk = tokenUtils.generateJwtAccessToken(loginUserDto);
            String rtk = tokenUtils.generateJwtAccessToken(loginUserDto);
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
        String authorization = req.getHeader("Authorization");
        String userEmail = tokenUtils.getUserEmailFromToken(authorization);

        TokenResponse tokenResponse = TokenResponse.builder()
                .code(TokenResponseCode.OK.getCode())
                .message(TokenResponseCode.OK.getMessage())
                .status(TokenResponseCode.OK.getHttpStatus())
                .data(userEmail).build();

        return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
    }
}
