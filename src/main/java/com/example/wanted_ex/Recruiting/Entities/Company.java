package com.example.wanted_ex.Recruiting.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    @JsonIgnore
    private int company_id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "country", length = 64, nullable = false)
    private String country;

    @Column(name = "region", length = 64, nullable = false)
    private String region;
}
