package kia.com.mybatistest.response;

import kia.com.mybatistest.model.dto.BoardUserDto;
import org.springframework.http.HttpStatus;

public enum BoardResponseCode {

    OK(200,HttpStatus.OK, "ok",new BoardUserDto()),
    DataIntegrityViolationException(400, HttpStatus.BAD_REQUEST,"필수 입력 데이터를 다 입력해야 합니다.",new BoardUserDto());
    private int code;
    private HttpStatus httpStatus;
    private String description;
    private Object data;

    BoardResponseCode(int code,
                     HttpStatus httpStatus,
                     String description,
                     Object data) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
        this.data = data;
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

    public Object getData() {return data;}
}
