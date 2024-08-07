package com.example.wanted_ex.Recruiting.Responses;

import com.example.wanted_ex.Recruiting.Entities.Company;
import com.example.wanted_ex.Recruiting.Entities.Recruiting;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class RecruitingDetailResp {
    private int recruiting_id;

    private Company company;

    private String position;

    private int reward;

    private String description;

    private String tech;

    private List<Integer> recruitings;

    public RecruitingDetailResp(Recruiting recruiting, List<Integer> recruitings) {
        this.recruiting_id = recruiting.getRecruiting_id();
        this.company = recruiting.getCompany();
        this.position = recruiting.getPosition();
        this.reward = recruiting.getReward();
        this.description = recruiting.getDescription();
        this.tech = recruiting.getTech();
        this.recruitings = recruitings;
    }
}
