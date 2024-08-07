package com.example.wanted_ex.Recruiting.Entities;

import io.micrometer.observation.annotation.Observed;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "submitting")
@Getter
@Setter
public class Submitting implements Serializable {
    @Id
    @Column(name = "recruiting_id", nullable = false)
    private int recruiting_id;

    @Id
    @Column(name = "account_id", length = 64, nullable = false)
    private String account_id;

    // 복합키 사용시 equals()와 hashCode()를 오버라이딩 할 필요 있음
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Submitting submitting = (Submitting) o;
        return recruiting_id == submitting.recruiting_id && account_id.equals(submitting.account_id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(recruiting_id, account_id);
    }
}
