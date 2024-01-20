package com.vh.curriculum_back.service.auth;

import com.vh.curriculum_back.models.users.UserRepository;
import com.vh.curriculum_back.models.users.dtos.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    //esse service é necessario para que seja possivel manter a autenticação do spring security
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    public boolean register(RegistrationDto registrationDto) {
        if (loadUserByUsername(registrationDto.login()) != null)
            return false;
        userRepository.save(tokenService.getUser(registrationDto));
        return true;
    }
}
