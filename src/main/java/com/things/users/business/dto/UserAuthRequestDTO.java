package com.things.users.business.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthRequestDTO {
    private String email;
    private String password;
}
