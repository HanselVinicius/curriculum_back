package com.vh.curriculum_back.service.auth;

import com.vh.curriculum_back.models.Users.User;
import com.vh.curriculum_back.models.Users.dtos.AuthDto;
import com.vh.curriculum_back.models.Users.dtos.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;


    public String authenticate(AuthDto authDto) {
        var token = new UsernamePasswordAuthenticationToken(authDto.login(),authDto.password());
        var authentication = manager.authenticate(token);
        return tokenService.generateToken((User) authentication.getPrincipal());
    }

    public boolean register(RegistrationDto registrationDto) {
        return userService.register(registrationDto);
    }

}
