package kia.com.mybatistest.model.dto;

import io.swagger.annotations.ApiParam;
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

    @ApiParam(value = "사용자 키 값")
    private Long userId;

    @ApiParam(value = "사용자 이름")
    private String userName;

    @ApiParam(value = "사용자 이메일")
    private String userEmail;

    @ApiParam(value = "사용자 비밀번호")
    private String userPassword;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")

    @ApiParam(value = "생성 날짜")
    private String createAt;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")

    @ApiParam(value = "수정 날짜")
    private String modifyAt;

    public JoinUserDto(String userName, String userEmail, String userPassword, String createAt, String modifyAt) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.createAt = createAt;
        this.modifyAt = modifyAt;
    }
}
