package kia.com.mybatistest.member.controller;

import kia.com.mybatistest.member.service.UserService;
import kia.com.mybatistest.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
