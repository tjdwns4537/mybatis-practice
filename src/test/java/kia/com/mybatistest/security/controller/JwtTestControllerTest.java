package kia.com.mybatistest.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kia.com.mybatistest.model.dto.LoginUserDto;
import kia.com.mybatistest.security.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(JwtTestController.class)
class JwtTestControllerTest {

    @Value("${jwt.secret}")
    private String token;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TokenUtils tokenUtils;

    @DisplayName("[JWT] 토큰 생성 테스트")
    @Test
    void testGenerateJwt() throws Exception{
        LoginUserDto loginUserDto = new LoginUserDto(1L, "test", "test@com", "1test", "1");

        String content = objectMapper.writeValueAsString(loginUserDto);

        log.info("token: {}",token);

        mockMvc.perform(
                post("/test/generateToken")
                        .content(content)
                        .header("Authorization","Bearer "+token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}