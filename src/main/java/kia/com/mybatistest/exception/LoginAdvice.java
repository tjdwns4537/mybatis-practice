package kia.com.mybatistest.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("kia.com.mybatistest.member.controller")
public class LoginAdvice {

//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<LoginResponse> emptyDataError() {
//        LoginResponse loginResponse = LoginResponse.builder()
//                .code(LoginResponseCode.DataIntegrityViolationException.getCode())
//                .httpStatus(LoginResponseCode.DataIntegrityViolationException.getHttpStatus())
//                .message(LoginResponseCode.DataIntegrityViolationException.getDescription()).build();
//
//        return new ResponseEntity<>(loginResponse, loginResponse.getHttpStatus());
//    }
}
