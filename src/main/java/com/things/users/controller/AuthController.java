package com.things.users.controller;

import com.things.users.business.AuthLoginService;
import com.things.users.business.dto.UserAuthRequestDTO;
import com.things.users.business.dto.UserAuthResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthLoginService authLoginService;

    @PostMapping("/login")
    public ResponseEntity<UserAuthResponseDTO> login(@RequestBody UserAuthRequestDTO userAuthDTO) {
        return ResponseEntity.ok(authLoginService.execute(userAuthDTO));
    }

}
