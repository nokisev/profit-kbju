package ru.nokisev.profit.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nokisev.profit.dto.UserDTO;
import ru.nokisev.profit.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping(value = "users/")
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::parseUser).toList();
    }

}
