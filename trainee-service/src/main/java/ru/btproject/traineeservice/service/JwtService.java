package ru.btproject.traineeservice.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
@Slf4j
public class JwtService {

    @Value("${security.jwt.validity-time-seconds}")
    private Integer validitySeconds;

    @Value("${security.jwt.secret-word}")
    private String secretWord;

    @Value("${security.jwt.header-name}")
    private String headerName;

    @Value("${security.jwt.header-prefix}")
    private String headerPrefix;

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secretWord).parseClaimsJws(token).getBody().getSubject();
    }

    public Jws<Claims> parseJwtToken(String authToken) {
        try {
            return Jwts.parser().setSigningKey(secretWord).parseClaimsJws(authToken);
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return null;
    }

    public String generateJwtHeaderFromUsername(String username) {
        String header = this.headerPrefix + ' ' + Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + validitySeconds * 1000))
                .signWith(SignatureAlgorithm.HS256, secretWord)
                .compact();
        log.info("Generated JWT header {} for {}", header, username);
        return header;
    }

    public String getJwtFromRequestHeader(HttpServletRequest request) {
        String header = request.getHeader(this.headerName);
        return header != null ? header.substring(this.headerPrefix.length() + 1) : null;
    }
}
