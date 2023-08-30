package kia.com.mybatistest.response;

import kia.com.mybatistest.model.dto.LoginUserDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum TokenResponseCode {
    OK(200, HttpStatus.OK, "정상", new LoginUserDto()),
    NOT_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 URL", new LoginUserDto()),
    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "서버에서 키 생성에 문제 생김", new LoginUserDto())
    ;

    private int code;
    private HttpStatus httpStatus;
    private String message;
    private Object data;

    TokenResponseCode(int code, HttpStatus httpStatus, String message, Object data) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }
}
