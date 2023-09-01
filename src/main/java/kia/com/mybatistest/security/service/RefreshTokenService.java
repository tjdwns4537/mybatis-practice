package kia.com.mybatistest.security.service;

import kia.com.mybatistest.model.dao.RefreshTokenMapper;
import kia.com.mybatistest.model.dto.RefreshTokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenMapper refreshTokenMapper;

    public List<RefreshTokenDto> getAllTokenList(){
        return refreshTokenMapper.getAllTokenList();
    }

    public RefreshTokenDto findById(Long id){
        return refreshTokenMapper.findById(id);
    }

    public RefreshTokenDto rtkSave(RefreshTokenDto refreshTokenDto){
        return refreshTokenMapper.rtkSave(refreshTokenDto);
    }
}
