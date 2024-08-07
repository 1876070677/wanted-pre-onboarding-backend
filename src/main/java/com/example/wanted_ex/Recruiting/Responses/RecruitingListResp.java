package com.example.wanted_ex.Recruiting.Responses;

import com.example.wanted_ex.Recruiting.Entities.Company;
import com.example.wanted_ex.Recruiting.Entities.Recruiting;
import lombok.Data;

@Data
public class RecruitingListResp {
    private int recruiting_id;
    private Company company;
    private String position;
    private int reward;
    private String tech;

    public RecruitingListResp(Recruiting recruiting) {
        this.recruiting_id = recruiting.getRecruiting_id();
        this.company = recruiting.getCompany();
        this.position = recruiting.getPosition();
        this.reward = recruiting.getReward();
        this.tech = recruiting.getTech();
    }
}
