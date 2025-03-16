package com.things.users.business;


import com.things.users.business.converter.UserConverter;
import com.things.users.business.dto.UserRequestDTO;
import com.things.users.business.dto.UserResponseDTO;
import com.things.users.infrastructure.entities.UserEntity;
import com.things.users.infrastructure.expection.ConflictException;
import com.things.users.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCreateService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public Optional<UserResponseDTO> execute (UserRequestDTO userDTO) throws ConflictException {

        emailExist(userDTO.getEmail());

        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        UserEntity user = UserConverter.fromUserDTOToUserEntity(userDTO);

        userRepository.save(user);

        return Optional.of(
                UserConverter
                        .fromUserEntityToUserDTO(
                                userRepository.save(user)
                        )
        );
    }
    private void emailExist(String email) throws ConflictException {
        boolean isEmailExist = userRepository.findByEmail(email).isPresent();
        if(isEmailExist){
            throw new ConflictException("Email Exist" );
        }

    }
}
