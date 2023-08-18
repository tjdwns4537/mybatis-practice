package kia.com.mybatistest.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class JoinUserDto {
    private Long user_id;
    private String user_name;
    private String user_email;
    private String user_password;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime create_at;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime modify_at;

    public JoinUserDto() {

    }

    public JoinUserDto(String user_name, String user_email, String user_password, LocalDateTime create_at, LocalDateTime modify_at) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.create_at = create_at;
        this.modify_at = modify_at;
    }

    public static JoinUserDto of(String user_name, String user_email, String user_password, LocalDateTime create_at, LocalDateTime modify_at) {
        return new JoinUserDto(user_name, user_email, user_password, create_at, modify_at);
    }
}
