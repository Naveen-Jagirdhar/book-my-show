package com.learnings.bookmyshow.exception;

public class InvalidMovieException extends RuntimeException {
    public InvalidMovieException(String message) {
        super(message);
    }
}
