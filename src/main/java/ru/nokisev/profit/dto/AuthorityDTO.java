package ru.nokisev.profit.dto;

import lombok.Data;
import ru.nokisev.profit.dao.Authority;

@Data
public class AuthorityDTO {

    private String username;
    private String authority;

    public static AuthorityDTO parseAuthorityDTO(Authority authority) {
        AuthorityDTO authorityDTO = new AuthorityDTO();
        if (authority != null) {
            authorityDTO.setUsername(authority.getUsername().getUsername());
            authorityDTO.setAuthority(authority.getAuthority());
        }

        return authorityDTO;
    }
}
