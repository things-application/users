package com.things.users.controller;


import com.things.users.business.UserCreateService;
import com.things.users.business.dto.UserRequestDTO;
import com.things.users.business.dto.UserResponseDTO;
import com.things.users.infrastructure.expection.ConflictException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    public final UserCreateService userCreateService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userDTO) throws ConflictException {
        return ResponseEntity.of(userCreateService.execute(userDTO));
    }
}
