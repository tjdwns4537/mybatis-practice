package kia.com.mybatistest.board.service;

import kia.com.mybatistest.model.dao.BoardMapper;
import kia.com.mybatistest.model.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService implements BoardServiceInterface{

    private final BoardMapper boardMapper;

    @Override
    public List<BoardDto> findByAll() {
        return boardMapper.findByAll();
    }

    @Override
    public BoardDto findById(Long id) {
        return boardMapper.findById(id);
    }

    @Override
    public void addBoard(BoardDto boardDto) {
        boardMapper.saveBoard(boardDto);
    }
}
