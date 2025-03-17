package com.things.users.business;

import com.things.users.business.converter.UserConverter;
import com.things.users.business.dto.UserResponseDTO;
import com.things.users.infrastructure.expection.UnauthorizedAccessException;
import com.things.users.infrastructure.repositories.UserRepository;
import com.things.users.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserGetByEmailService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public Optional<UserResponseDTO> execute(String token, String emailIntended) throws UnauthorizedAccessException {
        var jwtToken = token.substring(7);
        String extractedUsername = jwtUtil.extractClaims(jwtToken).getSubject();
        return Optional.ofNullable(Optional.ofNullable(extractedUsername    )
                .filter(emailIntended::equals)
                .flatMap(userRepository::findByEmail)
                .map(UserConverter::fromUserEntityToUserDTO)
                .orElseThrow(() -> new UnauthorizedAccessException("Acesso não autorizado")));
    }
}
