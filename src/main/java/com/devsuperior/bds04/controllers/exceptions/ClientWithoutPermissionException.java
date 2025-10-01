package com.devsuperior.bds04.controllers.exceptions;

public class ClientWithoutPermissionException extends RuntimeException{

    public ClientWithoutPermissionException() {
        super("Forbidden");
    }

}
