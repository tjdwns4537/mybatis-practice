package kia.com.mybatistest.model.dao;

import kia.com.mybatistest.model.dto.RefreshTokenDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RefreshTokenMapper {
    List<RefreshTokenDto> getAllTokenList();

    RefreshTokenDto findById(Long id);

    RefreshTokenDto rtkSave(RefreshTokenDto refreshTokenDto);
}
