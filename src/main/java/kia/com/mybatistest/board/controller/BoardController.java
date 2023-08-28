package kia.com.mybatistest.board.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
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
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "게시판 추가", description = "게시판 추가", tags = {"BoardController"})
    @ApiOperation(value = "Save Board")
    @PostMapping("/board/test/saveBoard")
    public HttpStatus boardSave(@RequestBody BoardDto boardDto) {
        boardService.saveBoard(boardDto);
        return HttpStatus.OK;
    }

    @Operation(summary = "게시판 전체 조회", description = "게시판 전체 리스트", tags = {"BoardController"})
    @ApiOperation(value = "Get All Board List")
    @GetMapping("/board/test/findByAll")
    public List<BoardDto> findByAll() {
        return boardService.findByAll();
    }
}
