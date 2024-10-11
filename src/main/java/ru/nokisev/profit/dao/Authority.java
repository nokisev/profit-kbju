package ru.nokisev.profit.dao;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User username;

    @Column
    private String authority;
}
