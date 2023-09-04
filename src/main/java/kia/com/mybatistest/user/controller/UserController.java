package kia.com.mybatistest.user.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import kia.com.mybatistest.response.TokenResponse;
import kia.com.mybatistest.response.TokenResponseCode;
import kia.com.mybatistest.response.UserResponse;
import kia.com.mybatistest.response.UserResponseCode;
import kia.com.mybatistest.security.service.LoginService;
import kia.com.mybatistest.user.service.UserService;
import kia.com.mybatistest.model.dto.UserDto;
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
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @Operation(summary = "회원 키ID 조회", description = "Id정보를 통한 회원 정보 조회", tags = {"UserController"})
    @ApiOperation(value = "Get User by userId")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findId(
            @PathVariable Long id
    ) {
        Optional<UserDto> result = userService.findById(id);

        if (result.isPresent()) {
            UserResponse userResponse = UserResponse.builder()
                    .code(UserResponseCode.OK.getCode())
                    .message(UserResponseCode.OK.getMessage())
                    .httpStatus(UserResponseCode.OK.getHttpStatus())
                    .data(result)
                    .build();

            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } else {
            UserResponse userResponse = UserResponse.builder()
                    .code(UserResponseCode.NotFound.getCode())
                    .message(UserResponseCode.NotFound.getMessage())
                    .httpStatus(UserResponseCode.NotFound.getHttpStatus())
                    .data(null)
                    .build();

            return new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        }

    }

    @Operation(summary = "회원 객체를 통해 저장",description = "회원 저장", tags = {"UserController"})
    @ApiOperation(value = "Save User")
    @PostMapping("/registration")
    public ResponseEntity<UserResponse> saveUserData(
        @RequestBody UserDto userDto
    ) {
        UserDto res = userService.saveUser(userDto);

        UserResponse userResponse = UserResponse.builder()
                .code(UserResponseCode.OK.getCode())
                .message(UserResponseCode.OK.getMessage())
                .httpStatus(UserResponseCode.OK.getHttpStatus())
                .data(res)
                .build();

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @Operation(summary = "회원 정보 전체 조회", description = "회원 정보 전체 리스트", tags = {"UserController"})
    @ApiOperation(value = "Find All User")
    @GetMapping("/total")
    public List<UserDto> getAllDataList() {
        return userService.getAllUserDataList();
    }

    @Operation(summary = "로그인", description = "회원 로그인 성공/실패 여부 확인", tags = {"UserController"})
    @ApiOperation(value = "Login User")
    @GetMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestBody LoginUserDto loginUserDto
            ) {

        log.info("입력된 데이터 : {}, {}",loginUserDto.getUserEmail(), loginUserDto.getUserPassword());

        Optional<UserDto> user = userService.findByIdAndPassword(loginUserDto);

        if(user.isPresent()){
            log.info("출력 데이터 : {}, {}", user.get().getUserEmail(), user.get().getUserPassword());

            if(loginService.login(user.get())){
                // 로그인 성공
                UserResponse userResponse = UserResponse.builder()
                        .code(UserResponseCode.OK.getCode())
                        .httpStatus(UserResponseCode.OK.getHttpStatus())
                        .message(UserResponseCode.OK.getMessage())
                        .data(user.get()).build();
                return new ResponseEntity<>(userResponse, HttpStatus.OK);
            } else {
                // 토큰 인증 실패
                TokenResponse tokenResponse = TokenResponse.builder()
                        .code(TokenResponseCode.UNAUTHORIZED.getCode())
                        .status(TokenResponseCode.UNAUTHORIZED.getHttpStatus())
                        .message(TokenResponseCode.UNAUTHORIZED.getMessage())
                        .data(null)
                        .build();

                return new ResponseEntity<>(tokenResponse, HttpStatus.UNAUTHORIZED);
            }

        } else{
            // DB에 데이터 조회 실패
            log.info("출력 데이터 : {}, {}", user.get().getUserId(), user.get().getUserPassword());
            UserResponse userResponse = UserResponse.builder()
                    .code(UserResponseCode.LoginFail.getCode())
                    .httpStatus(UserResponseCode.LoginFail.getHttpStatus())
                    .message(UserResponseCode.LoginFail.getMessage()).build();

            return new ResponseEntity<>(userResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
