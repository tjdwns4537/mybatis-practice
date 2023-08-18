package kia.com.mybatistest.member.controller;

import kia.com.mybatistest.exception.LoginResponse;
import kia.com.mybatistest.exception.LoginResponseCode;
import kia.com.mybatistest.member.service.UserService;
import kia.com.mybatistest.model.dto.JoinUserDto;
import kia.com.mybatistest.model.dto.LoginUserDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemberTestController {

    private final UserService userService;

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
        Optional.of(userService.findByIdAndPassword(loginUserDto));
        LoginResponse loginResponse = LoginResponse.builder()
                .code(LoginResponseCode.OK.getCode())
                .httpStatus(LoginResponseCode.OK.getHttpStatus())
                .message(LoginResponseCode.OK.getDescription()).build();
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
