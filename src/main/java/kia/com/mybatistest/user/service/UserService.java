package kia.com.mybatistest.user.service;

import kia.com.mybatistest.model.dao.UserMapper;
import kia.com.mybatistest.model.dto.UserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
    public Optional<UserDto> saveUser(UserDto userDto) {
        userMapper.saveUser(userDto); // 데이터베이스에 저장하고 생성된 기본 키 값을 userDto에 설정해줄 것입니다.

        // userDto에는 이제 새로운 기본 키 값이 설정되어 있을 것입니다.
        return Optional.of(userDto);
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
