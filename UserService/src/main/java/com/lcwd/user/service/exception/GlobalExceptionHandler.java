package com.lcwd.user.service.exception;

import com.lcwd.user.service.payload.APIResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponce> handleResourceNotfoundException(ResourceNotFoundException e)
    {
        String message = e.getMessage();
        APIResponce responce = APIResponce.builder().msg(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<APIResponce>(responce, HttpStatus.NOT_FOUND);
    }
}
