package kia.com.mybatistest.model.dto;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

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

    @ApiParam(value = "리프레쉬 토큰 id값")
    private Long rtkId;
}
