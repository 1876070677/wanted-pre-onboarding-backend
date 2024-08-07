package com.example.wanted_ex.Recruiting.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recruiting")
@Getter
@Setter
public class Recruiting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="recruiting_id")
    private int recruiting_id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(name = "position", length = 32, nullable = false)
    private String position;

    @Column(name = "reward", nullable = false)
    private int reward;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "tech", length = 32, nullable = false)
    private String tech;
}
