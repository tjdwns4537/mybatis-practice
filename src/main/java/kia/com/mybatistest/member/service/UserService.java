package kia.com.mybatistest.member.service;

import kia.com.mybatistest.model.dao.UserMapper;
import kia.com.mybatistest.model.dto.JoinUserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserMapper userMapper;

    @Override
    public void saveUser(JoinUserDto joinUserDto) {
        userMapper.saveUser(joinUserDto);
    }

    @Override
    public List<JoinUserDto> getAllUserDataList() {
        return userMapper.getAllUserDataList();
    }

    @Override
    public JoinUserDto findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public JoinUserDto findByIdAndPassword(LoginUserDto loginUserDto) {
        return userMapper.findByIdAndPassword(loginUserDto);
    }
}
