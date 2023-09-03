package kia.com.mybatistest.security.service;

import kia.com.mybatistest.model.dto.LoginUserDto;
import kia.com.mybatistest.model.dto.RefreshTokenDto;
import kia.com.mybatistest.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final TokenService tokenService;
    private final CookieService cookieService;
    private final RefreshTokenService refreshTokenService;

    public UserDto login(UserDto userDto) {

        // 로그인 -> user객체에 rtkId 있으면 그대로 반환, 없으면 atk,rtk 재발급
        Optional<Long> rtkId = Optional.of(userDto.getRtkId());

        if(rtkId.isPresent()) return userDto;
        else {
            String atk = tokenService.generateJwtAccessToken(userDto);
            String rtk = tokenService.generateJwtRefreshToken(userDto);

            // atk는 쿠키에 저장하고 반환
            cookieService.generateCookie(atk);
            cookieService.generateCookie(rtk);

            // rtk는 db와 쿠키에 저장
            RefreshTokenDto refreshTokenDto = refreshTokenService.rtkSave(RefreshTokenDto.of(rtk));

            // 저장된 id값을 userDto에 할당해주고 객체를 반환
            userDto.setRtkId(refreshTokenDto.getRtkId());
            return userDto;
        }
    }
}
