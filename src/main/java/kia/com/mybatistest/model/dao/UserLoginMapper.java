package kia.com.mybatistest.model.dao;

import kia.com.mybatistest.model.dto.LoginUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserLoginMapper {
    LoginUserDto login();
}
