package com.example.wanted_ex.Recruiting.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "account_id", length = 64)
    private String account_id;

    @Column(name = "name", length = 64)
    private String name;
}
