package kia.com.mybatistest.model.dao;

import kia.com.mybatistest.model.dto.BoardDto;
import kia.com.mybatistest.model.dto.BoardUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    List<BoardDto> findByAll(); // userId 만 조회

    List<BoardUserDto> findByBoardUserAll(); // board 내부에서 user 인스턴스 자체를 조회할 수 있음

    BoardDto findById(Long id);

    void saveBoard(BoardDto boardDto);

    void deleteAll();
}
