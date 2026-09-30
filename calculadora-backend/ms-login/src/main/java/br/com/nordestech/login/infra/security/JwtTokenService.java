package br.com.nordestech.login.infra.security;

import br.com.nordestech.login.domain.exception.UnauthorizedException;
import br.com.nordestech.login.domain.exception.enums.ErrorCode;
import br.com.nordestech.usuario.domain.model.Usuario;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtTokenService {

    @Value("${JWT_SECRET}")
    private String secret;

    @Value("${BEARER_TOKEN_EXPIRATION_MS}")
    private Long expirationMs;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String gerarToken(Usuario usuario) {
        Date agora = new Date();
        Date dataExpiracao = new Date(agora.getTime() + expirationMs);

        return Jwts.builder()
                .subject(usuario.getEmail())
                .claim("id", usuario.getIdUsuario())
                .claim("roles", usuario.getPerfis())
                .issuedAt(agora)
                .expiration(dataExpiracao)
                .signWith(getSigningKey())
                .compact();
    }

    public String validarETerEmail(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        } catch (JwtException e) {
            throw new UnauthorizedException(ErrorCode.EXPIRED_TOKEN);
        }
    }
}