package com.example.wanted_ex.Recruiting;

import com.example.wanted_ex.Recruiting.Entities.Recruiting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecruitingRepository extends JpaRepository<Recruiting, Integer> {
    @Query("SELECT r FROM Recruiting r WHERE r.company.name LIKE %:keyword% OR r.position LIKE %:keyword% OR r.tech LIKE %:keyword%")
    List<Recruiting> findByKeyword(@Param("keyword") String keyword);

    @Query("SELECT r.recruiting_id FROM Recruiting r WHERE r.company.company_id = :company_id")
    List<Integer> findByCompanyId(@Param("company_id") int company_id);
}
