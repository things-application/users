package com.things.users.business.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
