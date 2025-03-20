package com.things.users.business.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDateTime createAt;
}
