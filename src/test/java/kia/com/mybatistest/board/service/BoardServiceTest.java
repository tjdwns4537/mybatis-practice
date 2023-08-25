package kia.com.mybatistest.board.service;

import kia.com.mybatistest.model.dto.BoardDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.testng.annotations.AfterTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @BeforeEach
    public void init() {
        BoardDto boardDto1 = new BoardDto("testBoard1","testContent1", String.valueOf(LocalDateTime.now()),String.valueOf(LocalDateTime.now()));
        BoardDto boardDto2 = new BoardDto("testBoard2","testContent2", String.valueOf(LocalDateTime.now()),String.valueOf(LocalDateTime.now()));
        BoardDto boardDto3 = new BoardDto("testBoard3","testContent3", String.valueOf(LocalDateTime.now()),String.valueOf(LocalDateTime.now()));
        boardService.addBoard(boardDto1);
        boardService.addBoard(boardDto2);
        boardService.addBoard(boardDto3);
    }

    @AfterTest
    public void after() {
        boardService.deleteAll();
    }

    @Test
    void findByAll() {
        List<BoardDto> boardList = boardService.findByAll();

        BoardDto boardDto = boardList.get(0);

        Assertions.assertThat(boardDto.getBoard_title()).isEqualTo("testBoard1");
        Assertions.assertThat(boardDto.getBoard_content()).isEqualTo("testContent1");

    }

    @Test
    void findById() {
        BoardDto board = boardService.findById(1L);
        Assertions.assertThat(board.getBoard_title()).isEqualTo("testBoard1");
    }

    @Test
    void addBoard() {
    }
}