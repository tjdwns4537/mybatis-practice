package kia.com.mybatistest.board.service;

import kia.com.mybatistest.model.dto.BoardDto;
import kia.com.mybatistest.model.dto.UserDto;
import kia.com.mybatistest.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void init() {

    }

    @Test
    void findByBoardAll() {
        for(BoardDto i : boardService.findByAll()){
            UserDto user = userService.findById(i.getUserId());

            log.info("title: {}",i.getBoardTitle());
            log.info("content: {}",i.getBoardContent());
            log.info("userName: {}",user.getUserName());
            log.info("userEmail: {}",user.getUserEmail());
            log.info("userPassword: {}",user.getUserPassword());
        }
    }

    @Test
    void findById() {
        BoardDto board = boardService.findById(1L);
        Assertions.assertThat(board.getBoardTitle()).isEqualTo("testBoard1");
    }

    @Test
    void addBoard() {
        boardService.deleteAll();

        UserDto user1 = userService.findById(1L);
        UserDto user2 = userService.findById(2L);

        BoardDto boardDto1 = new BoardDto("testBoard1","testContent1", String.valueOf(LocalDateTime.now()), String.valueOf(LocalDateTime.now()), user1.getUserId());
        BoardDto boardDto2 = new BoardDto("testBoard2","testContent2", String.valueOf(LocalDateTime.now()), String.valueOf(LocalDateTime.now()), user2.getUserId());
        BoardDto boardDto3 = new BoardDto("testBoard3","testContent3", String.valueOf(LocalDateTime.now()),String.valueOf(LocalDateTime.now()), user1.getUserId());

        boardService.saveBoard(boardDto1);
        boardService.saveBoard(boardDto2);
        boardService.saveBoard(boardDto3);
    }
}