package kia.com.mybatistest.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

public enum LoginErrorCode {
    DataIntegrityViolationException(400, HttpStatus.BAD_REQUEST,"you should input data");

    private int code;
    private HttpStatus httpStatus;
    private String description;

    private LoginErrorCode(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDescription() {
        return description;
    }
}
