package kia.com.mybatistest.model.dao;

import kia.com.mybatistest.model.dto.UserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserMapper {
    List<UserDto> getAllUserDataList();
    Long saveUser(UserDto userDto);
    Optional<UserDto> findById(Long id);
    UserDto findByIdAndPassword(LoginUserDto loginUserDto);
}
