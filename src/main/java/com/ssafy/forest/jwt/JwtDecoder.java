package com.ssafy.forest.jwt;

import com.google.gson.Gson;
import com.ssafy.forest.exception.CustomException;
import com.ssafy.forest.exception.ErrorCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class JwtDecoder {

    @Value("${jwt.token.secretKey}")
    private String secretKey;

    @Value("${jwt.redirect-url}")
    private String url;

    public Long verifyJWT(HttpServletRequest request) throws UnsupportedEncodingException {
        log.info("key: {}", secretKey);

        String check = Optional.ofNullable(request.getHeader("Authorization"))
                .orElseThrow(() -> new CustomException(ErrorCode.TOKEN_NOT_FOUND));

        String authorization = request.getHeader("Authorization").substring(7);
        log.info("auto : {}", authorization);
        log.info("url : {}", url);
        secretKey = "Q4NSl604sgyHJj1qwEkR3ycUeR4uUAt7WJraD7EN3O9DVM4yyYuHxMEbSF4XXyYJkal13eqgB0F7Bq4HQ4NSl604sgyHJj1qwEkR3ycUeR4uUAt7WJraD7EN3O9DVM4yyYuHxMEbSF4XXyYJkal13eqgB0F7Bq4H";

        System.out.println(secretKey);

        Map<String, Object> claimMap = null;

        try {
            System.out.println(Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authorization).getBody());
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey) // Set SignKey
                    .parseClaimsJws(authorization) // 파싱 및 검증, 실패 시 에러
                    .getBody();

            claimMap = claims;

//            Date expiration = claims.get("exp", Date.class);
//            log.info("exp : {}", expiration);
        }
        catch (ExpiredJwtException e) { // 토큰이 만료되었을 경우
            log.info("# EXPIR TOKEN === {}", e);
            throw new CustomException(ErrorCode.AUTH_EXPIRED_TOKEN);
        }
        catch (Exception e) { // 그외 에러났을 경우
            log.info("# ERROR TOKEN === {}", e);
            throw new CustomException(ErrorCode.AUTH_WRONG_TOKEN);
        }

        Long userId = Long.valueOf(claimMap.get("userId").toString());

        return userId;
    }
}