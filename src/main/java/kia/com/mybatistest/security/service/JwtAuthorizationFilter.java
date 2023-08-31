package kia.com.mybatistest.security.service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kia.com.mybatistest.util.AuthConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1. 토큰이 필요하지 않은 API URL에 대해서 배열로 구성합니다. ( admin, test )
        List<String> notAuthorizationList = Arrays.asList(
                "/test/generateToken",
                "/test/dataByToken"
        );

        // 2. 토큰이 필요하지 않은 API URL의 경우 => 로직 처리 없이 다음 필터로 이동
        if (notAuthorizationList.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3. OPTIONS 요청일 경우 => 로직 처리 없이 다음 필터로 이동
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            filterChain.doFilter(request, response);
            return;
        }

        String atk = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals(AuthConstants.AUTH_COOKIE))
                .findFirst().map(Cookie::getValue)
                .orElse(null);

        String header = request.getHeader(AuthConstants.AUTH_HEADER); // Authorization Bearer ~~
        log.debug("header check: {}",header);

        try {
            if (header != null && !header.equalsIgnoreCase("")) { // header 내에 토큰이 존재하는 경우

                String token = tokenService.getTokenFromHeader(header); // 토큰 기반 사용자 아이디 반환 받는 메소드

                // [STEP3] 추출한 토큰이 유효한지 여부를 체크합니다.
                if (tokenService.isValidToken(token)) {

                    // [STEP4] 토큰을 기반으로 사용자 아이디를 반환 받는 메서드
                    String userEmail = tokenService.getUserEmailFromToken(token);
                    logger.debug("[+] user-email check: " + userEmail);

                    // [STEP5] 사용자 아이디가 존재하는지 여부 체크
                    if (userEmail != null && !userEmail.equalsIgnoreCase("")) {
                        filterChain.doFilter(request, response);
                    } else {

                        /** TODO: exception class 생성 필요 **/

//                        throw new BusinessExceptionHandler("TOKEN isn't userId", ErrorCode.BUSINESS_EXCEPTION_ERROR);
                    }
                    // 토큰이 유효하지 않은 경우
                } else {

                    /** TODO: exception class 생성 필요 **/

//                    throw new BusinessExceptionHandler("TOKEN is invalid", ErrorCode.BUSINESS_EXCEPTION_ERROR);
                }
            }
        } catch (Exception e) {

            /** TODO: 아래 예제 코드를 참조해 응답값 반환 후 종료 **/
            // Token 내에 Exception이 발생 하였을 경우 => 클라이언트에 응답값을 반환하고 종료합니다.
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json");
//            PrintWriter printWriter = response.getWriter();
//            JSONObject jsonObject = jsonResponseWrapper(e);
//            printWriter.print(jsonObject);
//            printWriter.flush();
//            printWriter.close();

        }
    }

    /**
     * 토큰 관련 Exception 발생 시 예외 응답값 구성
     *
     * @param e Exception
     * @return JSONObject
     */
    private JSONObject jsonResponseWrapper(Exception e) {

        String resultMsg = "";
        // JWT 토큰 만료
        if (e instanceof ExpiredJwtException) {
            resultMsg = "TOKEN Expired";
        }
        // JWT 허용된 토큰이 아님
        else if (e instanceof SignatureException) {
            resultMsg = "TOKEN SignatureException Login";
        }
        // JWT 토큰내에서 오류 발생 시
        else if (e instanceof JwtException) {
            resultMsg = "TOKEN Parsing JwtException";
        }
        // 이외 JTW 토큰내에서 오류 발생
        else {
            resultMsg = "OTHER TOKEN ERROR";
        }

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("status", 401);
        jsonMap.put("code", "9999");
        jsonMap.put("message", resultMsg);
        jsonMap.put("reason", e.getMessage());
        JSONObject jsonObject = new JSONObject(jsonMap);
        logger.error(resultMsg, e);
        return jsonObject;
    }
}
