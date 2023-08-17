package kia.com.mybatistest.member.service;

import kia.com.mybatistest.model.dao.UserMapper;
import kia.com.mybatistest.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserMapper userMapper;

    @Override
    public void saveUser(UserDto userDto) {
        userMapper.saveUser(userDto);
    }

    @Override
    public List<UserDto> getAllUserDataList() {
        return userMapper.getAllUserDataList();
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }
}
