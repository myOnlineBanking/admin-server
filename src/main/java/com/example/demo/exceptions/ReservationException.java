package com.example.demo.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationException extends RuntimeException{

    private final int status;

    public ReservationException(int status , String message){
        super(message);
        this.status = status;
    }
}