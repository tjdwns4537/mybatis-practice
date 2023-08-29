package kia.com.mybatistest.model.dao;

import kia.com.mybatistest.model.dto.JoinUserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<JoinUserDto> getAllUserDataList();
    JoinUserDto saveUser(JoinUserDto joinUserDto);
    JoinUserDto findById(Long id);
    JoinUserDto findByIdAndPassword(LoginUserDto loginUserDto);
}
