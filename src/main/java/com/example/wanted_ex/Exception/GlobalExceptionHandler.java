package com.example.wanted_ex.Exception;

import com.example.wanted_ex.Common.ResponseMessage;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.TransientObjectException;
import org.hibernate.TransientPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseMessage> NullPointerException(NullPointerException e) {
        ResponseMessage msg = new ResponseMessage();
        msg.setMessage(e.getMessage());
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseMessage> ConstraintViolationException(MethodArgumentNotValidException e) {
        ResponseMessage msg = new ResponseMessage();
        msg.setMessage("입력 인자가 유효하지 않습니다");
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseMessage> RuntimeException(RuntimeException e) {
        ResponseMessage msg = new ResponseMessage();
        msg.setMessage(e.getMessage());
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> Exception(Exception e) {
        ResponseMessage msg = new ResponseMessage();
        msg.setMessage(e.getMessage());
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }
}
