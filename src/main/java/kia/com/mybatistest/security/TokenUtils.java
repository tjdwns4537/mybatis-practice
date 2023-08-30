package kia.com.mybatistest.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import kia.com.mybatistest.model.dto.LoginUserDto;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 관련된 토큰 Util
 *
 * @author lee
 * @fileName TokenUtils
 * @since 2022.12.23
 */
@Log4j2
@Component
public class TokenUtils {

    private String jwtSecretKey;

    @Value("${jwt.secret}")
    public void setJwtSecretKey(String value) {
        jwtSecretKey = value;
    }

    /**
     * 사용자 정보를 기반으로 토큰을 생성하여 반환 해주는 메서드
     *
     * @param userDto LoginUserDto : 사용자 정보
     * @return String : 토큰
     */
    public String generateJwtToken(LoginUserDto userDto) {
        // 사용자 시퀀스를 기준으로 JWT 토큰을 발급하여 반환해줍니다.
        JwtBuilder builder = Jwts.builder()
                .setHeader(createHeader())                              // Header 구성
                .setClaims(createClaims(userDto))                       // Payload - Claims 구성
                .setSubject(String.valueOf(userDto.getLoginSq()))        // Payload - Subject 구성
                .signWith(SignatureAlgorithm.HS256, createSignature())  // Signature 구성
                .setExpiration(createExpiredDate());                    // Expired Date 구성
        return builder.compact();
    }

    /**
     * 토큰을 기반으로 사용자 정보를 반환 해주는 메서드
     *
     * @param token String : 토큰
     * @return String : 사용자 정보
     */
    public String parseTokenToUserInfo(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * 유효한 토큰인지 확인 해주는 메서드
     *
     * @param token String  : 토큰
     * @return boolean      : 유효한지 여부 반환
     */
    public boolean isValidToken(String token) {
        try {
            Claims claims = getClaimsFormToken(token);

            log.info("expireTime :" + claims.getExpiration());
            log.info("userEmail :" + claims.get("userEmail"));
            log.info("userName :" + claims.get("userName"));

            return true;
        } catch (ExpiredJwtException exception) {
            log.error("Token Expired");
            return false;
        } catch (JwtException exception) {
            log.error("Token Tampered");
            return false;
        } catch (NullPointerException exception) {
            log.error("Token is null");
            return false;
        }
    }

    /**
     * Header 내에 토큰을 추출합니다.
     *
     * @param header 헤더
     * @return String
     */
    public String getTokenFromHeader(String header) {
        return header.split(" ")[1];
    }

    /**
     * 토큰의 만료기간을 지정하는 함수
     *
     * @return Calendar
     */
    private Date createExpiredDate() {
        // 토큰 만료시간은 30일으로 설정
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, 8);     // 8시간
        // c.add(Calendar.DATE, 1);         // 1일
        return c.getTime();
    }

    /**
     * JWT의 "헤더" 값을 생성해주는 메서드
     *
     * @return HashMap<String, Object>
     */
    private Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();

        header.put("typ", "JWT");
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());
        return header;
    }

    /**
     * 사용자 정보를 기반으로 클래임을 생성해주는 메서드
     *
     * @param userDto 사용자 정보
     * @return Map<String, Object>
     */
    private Map<String, Object> createClaims(LoginUserDto userDto) {
        // 공개 클레임에 사용자의 이름과 이메일을 설정하여 정보를 조회할 수 있다.
        Map<String, Object> claims = new HashMap<>();

        log.info("userName :" + userDto.getUserName());
        log.info("userEmail :" + userDto.getUserEmail());

        claims.put("userName", userDto.getUserName());
        claims.put("userEmail", userDto.getUserEmail());

        return claims;
    }

    /**
     * JWT "서명(Signature)" 발급을 해주는 메서드
     *
     * Header, Payload의 데이터 무결성, 변조 방지를 위한 서명
     * Header + Payload를 합친 후 Secret키와 Header의 해싱 알고리즘으로 인코딩
     * @return Key
     */
    private Key createSignature() {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecretKey);
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    /**
     * 토큰 정보를 기반으로 Claims 정보를 반환받는 메서드
     *
     * @param token : 토큰
     * @return Claims : Claims
     */
    private Claims getClaimsFormToken(String token) {
        token = token.split(" ")[1];
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecretKey))
                .parseClaimsJws(token).getBody();
    }

    /**
     * 토큰을 기반으로 사용자 정보를 반환받는 메서드
     *
     * @param token : 토큰
     * @return String : 사용자 아이디
     */
    public String getUserEmailFromToken(String token) {
        Claims claims = getClaimsFormToken(token);
        return claims.get("userEmail").toString();
    }
}
