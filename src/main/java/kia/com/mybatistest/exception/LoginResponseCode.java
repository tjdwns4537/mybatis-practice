package kia.com.mybatistest.exception;

import org.springframework.http.HttpStatus;

public enum LoginResponseCode {
    OK(200, HttpStatus.OK, "ok"),
    DataIntegrityViolationException(400, HttpStatus.BAD_REQUEST,"모든 데이터를 다 입력해야 합니다."),
    LoginFail(400, HttpStatus.BAD_REQUEST,"로그인이 잘못되었습니다.");
    private int code;
    private HttpStatus httpStatus;
    private String description;

    private LoginResponseCode(int code, HttpStatus httpStatus, String description) {
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
