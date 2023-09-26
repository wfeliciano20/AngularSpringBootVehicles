package com.williamfeliciano.angularspringbootvehicles.config;

import com.williamfeliciano.angularspringbootvehicles.dto.ErrorDto;
import com.williamfeliciano.angularspringbootvehicles.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorDto> handleException(AppException ex){
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()), ex.getStatus());
    }
}
