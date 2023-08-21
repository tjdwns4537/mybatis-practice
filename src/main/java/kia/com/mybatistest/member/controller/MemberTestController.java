package kia.com.mybatistest.member.controller;

import kia.com.mybatistest.exception.LoginResponse;
import kia.com.mybatistest.exception.LoginResponseCode;
import kia.com.mybatistest.member.service.UserService;
import kia.com.mybatistest.model.dto.JoinUserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Slf4j
public class MemberTestController {

    private final UserService userService;

    @GetMapping("/user/test/{id}")
    public JoinUserDto findId(
            @PathVariable Long id
    ) {
        return userService.findById(id);
    }

    @PostMapping("/user/test/saveData")
    public HttpStatus saveUserData(
        @RequestBody JoinUserDto joinUserDto
    ) {
        userService.saveUser(joinUserDto);
        return HttpStatus.OK;
    }

    @GetMapping("/user/test/allData")
    public List<JoinUserDto> getAllDataList() {
        return userService.getAllUserDataList();
    }

    @GetMapping("/user/test/login")
    public ResponseEntity<LoginResponse> loginUser(
            @RequestBody LoginUserDto loginUserDto
            ) {

        log.info("입력된 데이터 : {}, {}",loginUserDto.getUserEmail(), loginUserDto.getUserPassword());

        Optional<JoinUserDto> user = userService.findByIdAndPassword(loginUserDto);

        if(user.isPresent()){
            log.info("출력 데이터 : {}, {}", user.get().getUserEmail(), user.get().getUserPassword());

            LoginResponse loginResponse = LoginResponse.builder()
                    .code(LoginResponseCode.OK.getCode())
                    .httpStatus(LoginResponseCode.OK.getHttpStatus())
                    .message(LoginResponseCode.OK.getDescription()).build();

            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        } else{
            log.info("출력 데이터 : {}, {}", user.get().getUserId(), user.get().getUserPassword());
            LoginResponse loginResponse = LoginResponse.builder()
                    .code(LoginResponseCode.LoginFail.getCode())
                    .httpStatus(LoginResponseCode.LoginFail.getHttpStatus())
                    .message(LoginResponseCode.LoginFail.getDescription()).build();

            return new ResponseEntity<>(loginResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
