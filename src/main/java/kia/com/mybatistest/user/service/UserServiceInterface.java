package kia.com.mybatistest.user.service;

import kia.com.mybatistest.model.dto.UserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    UserDto saveUser(UserDto userDto);
    List<UserDto> getAllUserDataList();
    Optional<UserDto> findById(Long id);
    Optional<UserDto> findByIdAndPassword(LoginUserDto loginUserDto);
    boolean passAuthorization(UserDto userDto, String email);

    LoginUserDto login(LoginUserDto loginUserDto);
}
