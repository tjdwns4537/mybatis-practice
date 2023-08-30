package kia.com.mybatistest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDto {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userSq;
}
