package kia.com.mybatistest.board.service;

import kia.com.mybatistest.model.dto.BoardDto;
import kia.com.mybatistest.model.dto.BoardUserDto;

import java.util.List;

public interface BoardServiceInterface {
    List<BoardDto> findByAll();

    List<BoardUserDto> findByBoardUserAll();

    BoardDto findById(Long id);

    void saveBoard(BoardDto boardDto);

    void deleteAll();
}
