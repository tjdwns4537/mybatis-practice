package kia.com.mybatistest.board.service;

import kia.com.mybatistest.model.dto.BoardDto;

import java.util.List;

public interface BoardServiceInterface {
    List<BoardDto> findByAll();

    BoardDto findById(Long id);

    void addBoard(BoardDto boardDto);
}
