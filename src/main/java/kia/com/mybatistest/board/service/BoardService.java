package kia.com.mybatistest.board.service;

import kia.com.mybatistest.model.dao.BoardMapper;
import kia.com.mybatistest.model.dto.BoardDto;
import kia.com.mybatistest.model.dto.BoardUserDto;
import kia.com.mybatistest.model.dto.JoinUserDto;
import kia.com.mybatistest.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService implements BoardServiceInterface{

    private final BoardMapper boardMapper;

    @Override
    public List<BoardDto> findByAll() {
        return boardMapper.findByAll();
    }

    @Override
    public List<BoardUserDto> findByBoardUserAll() { return boardMapper.findByBoardUserAll(); }

    @Override
    public BoardDto findById(Long id) {
        return boardMapper.findById(id);
    }

    @Override
    public BoardDto saveBoard(BoardDto boardDto) {
        boardMapper.saveBoard(boardDto);
        return boardDto;
    }

    @Override
    public void deleteAll() {
        boardMapper.deleteAll();
    }
}
