package com.learnings.bookmyshow.exception;

public class AlreadyBookException extends RuntimeException {
    public AlreadyBookException(Long showSeatId) {
        super("seat with id:"+ showSeatId +" is booked");
    }
}
