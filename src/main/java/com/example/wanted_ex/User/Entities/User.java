package com.example.wanted_ex.User.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "user_id", length = 64)
    private String user_id;

    @Column(name = "name", length = 64)
    private String name;
}
