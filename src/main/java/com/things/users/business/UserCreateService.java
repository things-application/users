package com.things.users.business;


import com.things.users.business.converter.UserConverter;
import com.things.users.business.dto.UserRequestDTO;
import com.things.users.business.dto.UserResponseDTO;
import com.things.users.infrastructure.entities.UserEntity;
import com.things.users.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCreateService {

    private final UserRepository userRepository;


    public Optional<UserResponseDTO> execute (UserRequestDTO userDTO){

        UserEntity user = UserConverter.fromUserDTOToUserEntity(userDTO);

        userRepository.save(user);

        return Optional.of(
                UserConverter.fromUserEntityToUserDTO(user)
        );
    }
}
