package kia.com.mybatistest.member.service;

import kia.com.mybatistest.model.dto.JoinUserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;

import java.util.List;

public interface UserServiceInterface {

    void saveUser(JoinUserDto joinUserDto);
    List<JoinUserDto> getAllUserDataList();

    JoinUserDto findById(Long id);
    JoinUserDto findByIdAndPassword(LoginUserDto loginUserDto);

}
