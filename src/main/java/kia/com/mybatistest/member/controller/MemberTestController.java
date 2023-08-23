package kia.com.mybatistest.member.controller;

import kia.com.mybatistest.response.UserResponse;
import kia.com.mybatistest.response.UserResponseCode;
import kia.com.mybatistest.member.service.UserService;
import kia.com.mybatistest.model.dto.JoinUserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Slf4j
public class MemberTestController {

    private final UserService userService;

    @GetMapping("/user/test/{id}")
    public ResponseEntity<UserResponse> findId(
            @PathVariable Long id
    ) {
        JoinUserDto result = userService.findById(id);

        UserResponse userResponse = UserResponse.builder()
                .code(UserResponseCode.OK.getCode())
                .message(UserResponseCode.OK.getDescription())
                .httpStatus(UserResponseCode.OK.getHttpStatus())
                .data(result)
                .build();

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
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
    public ResponseEntity<UserResponse> loginUser(
            @RequestBody LoginUserDto loginUserDto
            ) {

        log.info("입력된 데이터 : {}, {}",loginUserDto.getUserEmail(), loginUserDto.getUserPassword());

        Optional<JoinUserDto> user = userService.findByIdAndPassword(loginUserDto);

        if(user.isPresent()){
            log.info("출력 데이터 : {}, {}", user.get().getUserEmail(), user.get().getUserPassword());

            UserResponse userResponse = UserResponse.builder()
                    .code(UserResponseCode.OK.getCode())
                    .httpStatus(UserResponseCode.OK.getHttpStatus())
                    .message(UserResponseCode.OK.getDescription()).build();

            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } else{
            log.info("출력 데이터 : {}, {}", user.get().getUserId(), user.get().getUserPassword());
            UserResponse userResponse = UserResponse.builder()
                    .code(UserResponseCode.LoginFail.getCode())
                    .httpStatus(UserResponseCode.LoginFail.getHttpStatus())
                    .message(UserResponseCode.LoginFail.getDescription()).build();

            return new ResponseEntity<>(userResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
