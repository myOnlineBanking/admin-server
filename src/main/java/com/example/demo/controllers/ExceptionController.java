package com.example.demo.controllers;


import com.example.demo.dtos.ErrorClass;
import com.example.demo.exceptions.ReservationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ReservationException.class)
    public ResponseEntity<ErrorClass> handleChequeException(ReservationException ex, HttpServletRequest request) {
        logger.error("Reservation Service Error" , ex);
        return ResponseEntity.status(ex.getStatus()).body(new ErrorClass(ex.getStatus(), ex.getMessage(), request.getRequestURI()));
    }

}
