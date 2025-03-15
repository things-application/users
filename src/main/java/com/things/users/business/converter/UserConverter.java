package com.things.users.business.converter;


import com.things.users.business.dto.UserDTO;
import com.things.users.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    static public UserDTO fromUserEntityToUserDTO(UserEntity userEntity) {
        return UserDTO.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .build();
    }

    static public UserEntity fromUserDTOToUserEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword()).build();
    }
}
