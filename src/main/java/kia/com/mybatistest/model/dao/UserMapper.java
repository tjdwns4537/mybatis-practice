package kia.com.mybatistest.model.dao;

import kia.com.mybatistest.model.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<UserDto> getAllUserDataList();

    void saveUser(UserDto userDto);

    UserDto findById(Long id);
}
