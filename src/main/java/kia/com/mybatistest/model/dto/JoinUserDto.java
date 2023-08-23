package kia.com.mybatistest.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class JoinUserDto {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String createAt;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String modifyAt;

    public JoinUserDto(String userName, String userEmail, String userPassword, String createAt, String modifyAt) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.createAt = createAt;
        this.modifyAt = modifyAt;
    }
}
