package kia.com.mybatistest.board.service;

import kia.com.mybatistest.model.dto.BoardDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @BeforeEach
    public void init() {
        BoardDto boardDto1 = new BoardDto("testBoard","testContent", String.valueOf(LocalDateTime.now()),String.valueOf(LocalDateTime.now()));
        BoardDto boardDto2 = new BoardDto("testBoard","testContent", String.valueOf(LocalDateTime.now()),String.valueOf(LocalDateTime.now()));
        BoardDto boardDto3 = new BoardDto("testBoard","testContent", String.valueOf(LocalDateTime.now()),String.valueOf(LocalDateTime.now()));
        boardService.addBoard(boardDto1);
        boardService.addBoard(boardDto2);
        boardService.addBoard(boardDto3);
    }

    @Test
    void findByAll() {
        boardService.findByAll();
    }

    @Test
    void findById() {
    }

    @Test
    void addBoard() {
    }
}