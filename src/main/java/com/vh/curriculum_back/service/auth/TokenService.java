package com.vh.curriculum_back.service.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.vh.curriculum_back.models.Users.User;
import com.vh.curriculum_back.models.Users.dtos.RegistrationDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("{api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try{
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("VH")
                    .withSubject(user.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        }catch (JWTCreationException ex){
            throw new RuntimeException("Erro ao gerar token jwt ",ex);
        }
    }

    public String getSubject(String tokenJWT){
        try{
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("VH")
                    .build()
                    //por algum motivo quando testo no insonmia alguns espaços em branco vem no ctr+v por isso esse .trim() aqui
                    .verify(tokenJWT.trim())
                    .getSubject();
        }catch (Exception ex){
            throw new RuntimeException("TOKEN JWT INVALIDO OU EXPIRADO ",ex);
        }
    }

    public User getUser(RegistrationDto registrationDto){
        var senha = new BCryptPasswordEncoder().encode(registrationDto.password());
        return new User(registrationDto.login(),senha);

    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
