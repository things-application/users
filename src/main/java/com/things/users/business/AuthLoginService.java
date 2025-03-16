package com.things.users.business;

import com.things.users.business.dto.UserAuthRequestDTO;
import com.things.users.business.dto.UserAuthResponseDTO;
import com.things.users.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthLoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UserAuthResponseDTO execute (UserAuthRequestDTO  userAuthDTO) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                userAuthDTO.getEmail(), userAuthDTO.getPassword());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = jwtUtil.generateToken(authentication.getName());

        return UserAuthResponseDTO.builder().token(token).build();
    }

}
