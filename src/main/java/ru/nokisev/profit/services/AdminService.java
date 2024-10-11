package ru.nokisev.profit.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nokisev.profit.dao.Authority;
import ru.nokisev.profit.dao.User;
import ru.nokisev.profit.dto.AuthorityDTO;
import ru.nokisev.profit.dto.UserDTO;
import ru.nokisev.profit.repositories.AuthorityRepository;
import ru.nokisev.profit.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder encoder;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::parseUser).toList();
    }

    public UserDTO getUserById(Long id) {
        return UserDTO.parseUser(userRepository.findById(id).orElse(null));
    }

    public User createUser(UserDTO dto) {
        User user = UserDTO.parseUserDTO(dto);
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(UserDTO dto) {
        User user = userRepository.findById(dto.getId()).orElse(null);
        if (user != null) {
            user = UserDTO.parseUserDTO(dto);
            userRepository.save(user);
        }
        return user;
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresent(user -> userRepository.deleteById(id));
    }

    public AuthorityDTO addAuthority(AuthorityDTO authorityDTO) {
        User user = userRepository.findUserByUsername(authorityDTO.getUsername());
        Authority authority = new Authority();
        authority.setAuthority(authorityDTO.getAuthority());
        authority.setUsername(user);
        authorityRepository.save(authority);
        return AuthorityDTO.parseAuthorityDTO(authority);
    }

    public List<AuthorityDTO> getAuthority() {
        return authorityRepository.findAll().stream().map(AuthorityDTO::parseAuthorityDTO).toList();
    }

}
