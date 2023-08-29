package kia.com.mybatistest.token;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenInfo {

    private String grantType; //JWT 인증 타입 (Bearer)
    private String accessToken;
    private String refreshToken;
}
