package org.bfsi.orchestration.exception;

import org.bfsi.orchestration.bean.ErrorResponseBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = LeadNotFoundException.class)
    public ResponseEntity<Object> leadNotFoundException(LeadNotFoundException leadNotFoundException){
        return new ResponseEntity<>(ErrorResponseBean.builder()
                .errorCode(HttpStatus.NOT_FOUND.toString())
                .message(leadNotFoundException.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Object> invalidRequestExceptionHandler(InvalidRequestException invalidRequestException){

        return new ResponseEntity<>(
                ErrorResponseBean.builder()
                        .errorCode(HttpStatus.BAD_REQUEST.toString())
                        .message(invalidRequestException.getMessage())
                        .build()
                ,
                HttpStatus.BAD_REQUEST);
    }

}
