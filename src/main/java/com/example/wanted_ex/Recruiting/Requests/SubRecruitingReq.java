package com.example.wanted_ex.Recruiting.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 기업이 공고를 등록할 때의 request 객체
 */
@RequiredArgsConstructor
@ToString
@Data
public class SubRecruitingReq {
    
    private final int recruiting_id;
    @NotNull
    private final int company_id;
    @NotBlank
    private final String position;
    @NotNull
    private final int reward;
    @NotBlank
    private final String description;
    @NotBlank
    private final String tech;
}
