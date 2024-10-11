package ru.nokisev.profit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import ru.nokisev.profit.dao.User;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    @Id
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private String email;
    private String lastActivity;

    public static UserDTO parseUser(User user) {
        UserDTO dto = new UserDTO();
        if (user != null) {
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setPassword(user.getPassword());
            dto.setEnabled(user.isEnabled());
            dto.setEmail(user.getEmail());
            dto.setLastActivity(user.getLastActivity());
        }
        return dto;
    }

    public static User parseUserDTO(UserDTO dto) {
        User user = new User();
        if (dto != null) {
            user.setId(dto.getId());
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword());
            user.setEnabled(dto.isEnabled());
            user.setEmail(dto.getEmail());
            user.setLastActivity(dto.getLastActivity());
        }
        return user;
    }
}
