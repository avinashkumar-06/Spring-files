package org.avinashcodes.weatherforecast.exception;

public class UserException extends RuntimeException{

    private String message;

    public UserException() {
    }
    public UserException(String message) {
        super(message);
        this.message = message;
    }
}
