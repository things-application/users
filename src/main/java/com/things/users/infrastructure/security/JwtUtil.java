package com.things.users.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;


@Service
public class JwtUtil {

    // Chave secreta usada para assinar e verificar tokens JWT
    private final String secretKey = "sua-chave-secreta-super-segura-que-deve-ser-bem-longa";
    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    // Gera um token JWT com o nome de usuário e validade de 1 hora
    public String generateToken(String username) {
        Instant now = Instant.now();
        Instant expiration = now.plusSeconds(3600); // 1 hora

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expiration))
                .signWith(key) // O algoritmo é inferido a partir da key
                .compact();
    }

    // Extrai as claims do token JWT (informações adicionais do token)
    public Claims extractClaims(String token) {
        String jwtToken = token.trim();
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    // Extrai o email (subject) do token JWT
    public String extrairEmailToken(String token) {
        return extractClaims(token).getSubject();
    }

    // Verifica se o token JWT está expirado
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    // Valida o token JWT verificando o nome de usuário e se o token não está expirado
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extrairEmailToken(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }
}
