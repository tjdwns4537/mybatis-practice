package kia.com.mybatistest.model.dao;

import kia.com.mybatistest.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    List<BoardDto> findByAll();

    BoardDto findById(Long id);

    void saveBoard(BoardDto boardDto);

}
