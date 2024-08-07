package com.example.wanted_ex.Recruiting;

import com.example.wanted_ex.Recruiting.Entities.Company;
import com.example.wanted_ex.Recruiting.Entities.Recruiting;
import com.example.wanted_ex.Recruiting.Requests.ModRecruitingReq;
import com.example.wanted_ex.Recruiting.Requests.SubRecruitingReq;
import com.example.wanted_ex.Recruiting.Responses.RecruitingDetailResp;
import com.example.wanted_ex.Recruiting.Responses.RecruitingListResp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecruitingService {
    private final RecruitingRepository recruitingRepository;

    @Transactional
    public void addRecruiting(SubRecruitingReq subRecruitingReq) {
        Company company = new Company();
        company.setCompany_id(subRecruitingReq.getCompany_id());

        Recruiting recruiting = new Recruiting();
        recruiting.setCompany(company);
        recruiting.setPosition(subRecruitingReq.getPosition());
        recruiting.setDescription(subRecruitingReq.getDescription());
        recruiting.setReward(subRecruitingReq.getReward());
        recruiting.setTech(subRecruitingReq.getTech());
        try {
            recruitingRepository.save(recruiting);
        } catch (Exception e) {
            throw new RuntimeException("제약 조건에 의해 공고 등록에 실패하였습니다");
        }

    }

    @Transactional
    public void modifyRecruiting(ModRecruitingReq modRecruitingReq) {
        // recruiting_id를 이용해서 엔티티 조회
        Recruiting recruiting = recruitingRepository.findById(modRecruitingReq.getRecruiting_id())
                .orElseThrow(() -> new RuntimeException("해당 공고를 찾을 수 없습니다."));
        recruiting.setPosition(modRecruitingReq.getPosition());
        recruiting.setPosition(modRecruitingReq.getPosition());
        recruiting.setDescription(modRecruitingReq.getDescription());
        recruiting.setReward(modRecruitingReq.getReward());
        recruiting.setTech(modRecruitingReq.getTech());
        try {
            recruitingRepository.save(recruiting);
        } catch (Exception e) {
            throw new RuntimeException("공고 수정에 실패하였습니다");
        }
    }

    public List<RecruitingListResp> getAllRecruitingList() {
        List<Recruiting> recruitingList = recruitingRepository.findAll();

        List<RecruitingListResp> list = new ArrayList<>();
        for (Recruiting recruiting : recruitingList) {
            RecruitingListResp resp = new RecruitingListResp(recruiting);
            list.add(resp);
        }
        return list;
    }

    public RecruitingDetailResp getRecruitingDetail(int recruiting_id) {
        Recruiting recruiting = recruitingRepository.findById(recruiting_id)
                .orElseThrow(() -> new RuntimeException("해당 공고를 찾을 수 없습니다"));
        List<Integer> recruitingsByCompany_id = recruitingRepository.findByCompanyId(recruiting.getCompany().getCompany_id());

        RecruitingDetailResp resp = new RecruitingDetailResp(recruiting, recruitingsByCompany_id);
        return resp;
    }

    public List<RecruitingListResp> getRecruitingByKeyword(String keyword) {
        List<Recruiting> recruitingList = recruitingRepository.findByKeyword(keyword);

        List<RecruitingListResp> list = new ArrayList<>();
        for (Recruiting recruiting : recruitingList) {
            RecruitingListResp resp = new RecruitingListResp(recruiting);
            list.add(resp);
        }

        return list;
    }

    @Transactional
    public void deleteRecruiting(int recruiting_id) {
        recruitingRepository.deleteById(recruiting_id);
    }
}
