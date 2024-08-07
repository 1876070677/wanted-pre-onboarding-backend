package com.example.wanted_ex.User;

import com.example.wanted_ex.User.Entities.Submitting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SubmittingRepository extends JpaRepository<Submitting, Integer> {
    @Query("SELECT s FROM Submitting s WHERE s.recruiting.recruiting_id = :recruiting_id AND s.user.user_id = :user_id")
    Optional<Submitting> findByRecruitingIdAndUserId(@Param("recruiting_id") int recruiting_id, @Param("user_id") String user_id);
}
