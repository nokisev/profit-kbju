package ru.nokisev.profit.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nokisev.profit.dao.User;
import ru.nokisev.profit.dto.AuthorityDTO;
import ru.nokisev.profit.dto.UserDTO;
import ru.nokisev.profit.services.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;

    @GetMapping(value = "/get-all-users")
    public List<UserDTO> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping(value = "/get-user/{id}")
    public UserDTO getUserById(@PathVariable(value = "id") Long id) {
        return service.getUserById(id);

    }

    @PostMapping(value = "/create-user")
    public User createUser(@RequestBody UserDTO userDTO) {
        return service.createUser(userDTO);
    }

    @PutMapping(value = "/update-user")
    public User updateUser(@RequestBody UserDTO user) {
        return service.updateUser(user);
    }


    @DeleteMapping(value = "/delete-user/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
    }

    @PostMapping(value = "/add_authority")
    public AuthorityDTO addAuthority(@RequestBody AuthorityDTO authorityDTO) {
        return service.addAuthority(authorityDTO);
    }

    @GetMapping(value = "/get_authority")
    public List<AuthorityDTO> getAuthority() {
        return service.getAuthority();
    }
}
