package kia.com.mybatistest.model.dao;

import kia.com.mybatistest.model.dto.UserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<UserDto> getAllUserDataList();
    UserDto saveUser(UserDto userDto);
    UserDto findById(Long id);
    UserDto findByIdAndPassword(LoginUserDto loginUserDto);
}
