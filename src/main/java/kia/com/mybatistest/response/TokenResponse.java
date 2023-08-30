package kia.com.mybatistest.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class TokenResponse {
    private int code;
    private HttpStatus status;
    private String message;
    private Object data;
}
