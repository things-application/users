package com.things.users.business.converter;


import com.things.users.business.dto.UserRequestDTO;
import com.things.users.business.dto.UserResponseDTO;
import com.things.users.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    static public UserResponseDTO fromUserEntityToUserDTO(UserEntity userEntity) {
        return UserResponseDTO.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .build();
    }

    static public UserEntity fromUserDTOToUserEntity(UserRequestDTO userDTO) {
        return UserEntity.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword()).build();
    }
}
