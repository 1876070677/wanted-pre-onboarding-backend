package com.example.wanted_ex.User;

import com.example.wanted_ex.Recruiting.Entities.Recruiting;
import com.example.wanted_ex.User.Entities.Submitting;
import com.example.wanted_ex.User.Entities.User;
import com.example.wanted_ex.User.Requests.SubmittingReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final SubmittingRepository submittingRepository;

    @Transactional
    public void submit(SubmittingReq submittingReq) throws RuntimeException {
        Submitting existSubmitting = submittingRepository.findByRecruitingIdAndUserId(submittingReq.getRecruiting_id(), submittingReq.getUser_id())
                .orElse(null);
        if (existSubmitting == null) {
            Submitting submitting = new Submitting();

            Recruiting recruiting = new Recruiting();
            recruiting.setRecruiting_id(submittingReq.getRecruiting_id());

            User user = new User();
            user.setUser_id(submittingReq.getUser_id());

            submitting.setUser(user);
            submitting.setRecruiting(recruiting);
            try {
                submittingRepository.save(submitting);
            } catch (Exception e) {
                throw new RuntimeException("제약 조건에 의해 신청에 실패하였습니다");
            }
        } else {
            throw new RuntimeException("이미 신청한 공고입니다.");
        }
    }
}
