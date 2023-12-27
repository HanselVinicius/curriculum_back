package com.vh.curriculum_back.controller.auth;

import com.vh.curriculum_back.models.Users.dtos.AuthDto;
import com.vh.curriculum_back.models.Users.dtos.RegistrationDto;
import com.vh.curriculum_back.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
public class AuthController {


    @Autowired
    private AuthenticationService authService;


    @PostMapping("/login")
    @Description("Endpoint to login")
    public ResponseEntity login(@RequestBody @Valid AuthDto authDto) {
        return ResponseEntity.ok().body(authService.authenticate(authDto));
    }


    @PostMapping("/register")
    @Description("Endpoint to register")
    public ResponseEntity register(@RequestBody @Valid RegistrationDto registrationDto) {
        if (!authService.register(registrationDto))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().build();
    }

}
