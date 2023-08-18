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
    private String userEmail;
    private String userPassword;

    public static LoginUserDto of(String userEmail, String userPassword) {
        return new LoginUserDto(userEmail, userPassword);
    }
}
