package kia.com.mybatistest.response;

import kia.com.mybatistest.model.dto.UserDto;
import org.springframework.http.HttpStatus;

public enum UserResponseCode {

    OK(200, HttpStatus.OK, "ok",new UserDto()),
    DataIntegrityViolationException(400, HttpStatus.BAD_REQUEST,"필수 입력 데이터를 다 입력해야 합니다.",new UserDto()),
    LoginFail(400, HttpStatus.BAD_REQUEST,"로그인이 잘못되었습니다.",new UserDto()),

    NotFound(401, HttpStatus.NOT_FOUND, "입력된 정보를 찾지 못했습니다.", new UserDto());
    private int code;
    private HttpStatus httpStatus;
    private String message;
    private Object data;

    UserResponseCode(int code,
                             HttpStatus httpStatus,
                             String message,
                             Object data) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {return data;}
}
