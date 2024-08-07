package com.example.wanted_ex.User;

import com.example.wanted_ex.Common.ResponseMessage;
import com.example.wanted_ex.User.Entities.Submitting;
import com.example.wanted_ex.User.Requests.SubmittingReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/submit")
    public ResponseEntity<ResponseMessage> submit(@RequestBody @Valid SubmittingReq submittingReq) {
        userService.submit(submittingReq);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("success");

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
