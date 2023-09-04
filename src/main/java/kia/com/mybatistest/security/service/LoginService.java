package kia.com.mybatistest.security.service;

import kia.com.mybatistest.model.dto.LoginUserDto;
import kia.com.mybatistest.model.dto.RefreshTokenDto;
import kia.com.mybatistest.model.dto.UserDto;
import kia.com.mybatistest.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final TokenService tokenService;
    private final CookieService cookieService;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public boolean login(UserDto userDto) {

        String atk = tokenService.generateJwtToken(userDto, 1);
        String rtk = tokenService.generateJwtToken(userDto, 0);

        // atk는 쿠키에 저장하고 반환
        cookieService.generateCookie(atk);
        cookieService.generateCookie(rtk);

        // rtk는 db와 쿠키에 저장
        RefreshTokenDto refreshTokenDto = refreshTokenService.rtkSave(RefreshTokenDto.of(rtk));

        // 저장된 id값을 userDto에 할당해주고 객체를 반환
        Optional<UserDto> result = userService.findById(refreshTokenDto.getRtkId());

        if (!result.isPresent()) {
            return result.isEmpty();
        }

        return true;
    }
}
