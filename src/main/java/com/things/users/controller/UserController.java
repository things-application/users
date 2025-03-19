package com.things.users.controller;


import com.things.users.business.UserCreateService;
import com.things.users.business.UserGetByEmailService;
import com.things.users.business.dto.UserRequestDTO;
import com.things.users.business.dto.UserResponseDTO;
import com.things.users.infrastructure.expection.ConflictException;
import com.things.users.infrastructure.expection.UnauthorizedAccessException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    public final UserCreateService userCreateService;
    public final UserGetByEmailService  userGetByEmailService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userDTO) throws ConflictException {
        return ResponseEntity.of(userCreateService.execute(userDTO));
    }


    @GetMapping("/{email}")
    public ResponseEntity<Optional<UserResponseDTO>> getUserByEmail(@RequestHeader("Authorization") String token, @PathVariable String email) throws UnauthorizedAccessException {
        return ResponseEntity.ok(userGetByEmailService.execute(token, email));
    }
}
