package com.example.wanted_ex.Recruiting;

import com.example.wanted_ex.Common.ResponseMessage;
import com.example.wanted_ex.Recruiting.Entities.Recruiting;
import com.example.wanted_ex.Recruiting.Requests.ModRecruitingReq;
import com.example.wanted_ex.Recruiting.Requests.SubRecruitingReq;
import com.example.wanted_ex.Recruiting.Responses.RecruitingDetailResp;
import com.example.wanted_ex.Recruiting.Responses.RecruitingListResp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruit")
public class RecruitingController {
    private final RecruitingService recruitingService;

    @PostMapping("/submit")
    public ResponseEntity<ResponseMessage> addRecruiting(@RequestBody @Valid SubRecruitingReq subRecruitingReq) {
        recruitingService.addRecruiting(subRecruitingReq);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Success");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<ResponseMessage> modifyRecruiting(@RequestBody @Valid ModRecruitingReq modRecruitingReq) {
        recruitingService.modifyRecruiting(modRecruitingReq);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Success");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseMessage> deleteRecruiting(@RequestParam(name = "rec_id") int recruiting_id) {
        recruitingService.deleteRecruiting(recruiting_id);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Success");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseMessage> getAllRecruitingList() {
        List<RecruitingListResp> recruitingList = recruitingService.getAllRecruitingList();

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Success");
        responseMessage.setData(recruitingList);

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<ResponseMessage> getRecruitingDetail(@RequestParam(name = "rec_id") int recruiting_id) {
        RecruitingDetailResp resp = recruitingService.getRecruitingDetail(recruiting_id);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Success");
        responseMessage.setData(resp);

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseMessage> getRecruitingByKeyword(@RequestParam(name = "search") String keyword) {
        List<RecruitingListResp> recruitingList = recruitingService.getRecruitingByKeyword(keyword);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Success");
        responseMessage.setData(recruitingList);

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
