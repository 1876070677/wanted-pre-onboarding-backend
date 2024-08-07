package com.example.wanted_ex.Recruiting;

import com.example.wanted_ex.Recruiting.Requests.SubRecruitingReq;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recruit")
public class RecruitingController {
    @PostMapping("/submit")
    public String addRecruiting(@RequestBody @Valid SubRecruitingReq subRecruitingReq) {
        System.out.println(subRecruitingReq.toString());
        return subRecruitingReq.toString();
    }
}
