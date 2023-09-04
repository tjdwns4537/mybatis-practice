package kia.com.mybatistest.user.service;

import kia.com.mybatistest.model.dao.UserMapper;
import kia.com.mybatistest.model.dto.UserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserServiceInterface {

    /**
     * TODO
     *  - 비밀번호 DB에 넣기 전에 암호화 필요
     * **/

    private final UserMapper userMapper;

    @Override
    public UserDto saveUser(UserDto userDto) {
        Long l = userMapper.saveUser(userDto);
        Optional<UserDto> user = findById(l);
        return user.get();
    }

    @Override
    public List<UserDto> getAllUserDataList() {
        return userMapper.getAllUserDataList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public Optional<UserDto> findByIdAndPassword(LoginUserDto loginUserDto) {
        return Optional.ofNullable(userMapper.findByIdAndPassword(loginUserDto));
    }
    @Override
    public boolean passAuthorization(UserDto userDto, String email) {
        if(userDto.getUserEmail().equals(email)) return true;
        return false;
    }

    @Override
    public LoginUserDto login(LoginUserDto loginUserDto) {
        userMapper.findByIdAndPassword(loginUserDto);
        return null;
    }
}
