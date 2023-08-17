package kia.com.mybatistest.member.controller;

import kia.com.mybatistest.member.service.UserService;
import kia.com.mybatistest.model.dto.UserDto;
import kia.com.mybatistest.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberTestController {

    private final UserService userService;

    @PostMapping("/user/test/saveData")
    public HttpStatus saveUserData(
        @RequestBody UserDto userDto
    ) {
        userService.saveUser(userDto);
        return HttpStatus.OK;
    }

    @GetMapping("/user/test/allData")
    public List<UserDto> getAllDataList() {
        return userService.getAllUserDataList();
    }
}
