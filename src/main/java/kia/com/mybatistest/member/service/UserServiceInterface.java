package kia.com.mybatistest.member.service;

import kia.com.mybatistest.model.dto.UserDto;

import java.util.List;

public interface UserServiceInterface {

    void saveUser(UserDto userDto);
    List<UserDto> getAllUserDataList();

    UserDto findById(Long id);
}
