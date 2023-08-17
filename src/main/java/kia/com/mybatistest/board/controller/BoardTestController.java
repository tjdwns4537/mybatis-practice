package kia.com.mybatistest.board.controller;

import kia.com.mybatistest.board.service.BoardService;
import kia.com.mybatistest.model.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardTestController {

    private final BoardService boardService;

    @PostMapping("/board/test/saveBoard")
    public HttpStatus boardSave(@RequestBody BoardDto boardDto) {
        boardService.saveBoard(boardDto);
        return HttpStatus.OK;
    }

    @GetMapping("/board/test/findByAll")
    public List<BoardDto> findByAll() {
        return boardService.findByAll();
    }
}
