package com.things.users.business.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
    private String firstName;
    private String lastName;
    private String email;
}
