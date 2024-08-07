package com.example.wanted_ex.User.Entities;

import com.example.wanted_ex.Recruiting.Entities.Recruiting;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * 사용자는 지원 공고마다 한 번 지원할 수 있음
 * 즉, (지원 공고 id, 사용자 id)가 하나의 키여야 함
 */
@Entity
@Table(name = "submitting")
@Data
public class Submitting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int submitting_id;

    @ManyToOne
    @JoinColumn(name = "recruiting_id", nullable = false)
    private Recruiting recruiting;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
