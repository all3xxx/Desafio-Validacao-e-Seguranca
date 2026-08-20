package com.devsuperior.bds04.controllers.exceptions;

public class InvalidTokenException extends RuntimeException{

    public InvalidTokenException() {
        super("Invalid token");
    }

}
