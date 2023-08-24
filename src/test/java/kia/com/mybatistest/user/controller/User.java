package kia.com.mybatistest.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kia.com.mybatistest.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class User {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findId() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String responseJson = "{\"userId\": 1," +
                "\"userName\": \"test2\"," +
                "\"userEmail\": \"test2@com\"," +
                "\"userPassword\": \"test2s123\"," +
                "\"createAt\": \"2023-08-10 01:01:01\"," +
                "\"modifyAt\": \"2023-08-21 13:59:43\"}";

        mockMvc.perform(get("/user/test/{id}", 1L))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void saveUserData() {
    }

    @Test
    void getAllDataList() {
    }

    @Test
    void loginUser() {
    }
}