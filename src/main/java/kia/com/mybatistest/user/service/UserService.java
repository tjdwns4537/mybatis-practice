package kia.com.mybatistest.user.service;

import kia.com.mybatistest.model.dao.UserMapper;
import kia.com.mybatistest.model.dto.JoinUserDto;
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
    public Optional<JoinUserDto> findByIdAndPassword(LoginUserDto loginUserDto) {
        log.info("로그인 조회 : {}, {}", loginUserDto.getUserEmail(), loginUserDto.getUserPassword());
        return Optional.ofNullable(userMapper.findByIdAndPassword(loginUserDto));
    }
}
