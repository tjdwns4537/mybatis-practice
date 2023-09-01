package kia.com.mybatistest.user.service;

import kia.com.mybatistest.model.dto.UserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    UserDto saveUser(UserDto userDto);
    List<UserDto> getAllUserDataList();
    UserDto findById(Long id);
    Optional<UserDto> findByIdAndPassword(LoginUserDto loginUserDto);

}
