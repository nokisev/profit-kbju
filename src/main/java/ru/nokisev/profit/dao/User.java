package ru.nokisev.profit.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String username;
    private String password;
    @Column(name = "enabled")
    private boolean enabled;
    private String email;
    @Column(name = "last_activity")
    private String lastActivity;


}
