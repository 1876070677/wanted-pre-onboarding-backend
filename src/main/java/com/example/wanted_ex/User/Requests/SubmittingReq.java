package com.example.wanted_ex.User.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubmittingReq {
    @NotNull
    private int recruiting_id;
    @NotBlank
    private String user_id;
}
