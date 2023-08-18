package kia.com.mybatistest.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("kia.com.mybatistest.member.controller")
public class LoginAdvice {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<LoginResponse> emptyDataError() {
        LoginResponse loginResponse = LoginResponse.builder()
                .code(LoginErrorCode.DataIntegrityViolationException.getCode())
                .httpStatus(LoginErrorCode.DataIntegrityViolationException.getHttpStatus())
                .message(LoginErrorCode.DataIntegrityViolationException.getDescription()).build();

        return new ResponseEntity<>(loginResponse, loginResponse.getHttpStatus());
    }
}
