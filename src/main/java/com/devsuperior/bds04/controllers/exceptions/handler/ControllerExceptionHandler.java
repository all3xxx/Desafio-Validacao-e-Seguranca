package com.devsuperior.bds04.controllers.exceptions.handler;

import com.devsuperior.bds04.controllers.exceptions.ClientWithoutPermissionException;
import com.devsuperior.bds04.controllers.exceptions.InvalidTokenException;
import com.devsuperior.bds04.dto.CustomErrorDTO;
import com.devsuperior.bds04.dto.ValidationErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<CustomErrorDTO> invalidToken(InvalidTokenException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        CustomErrorDTO error = new CustomErrorDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ClientWithoutPermissionException.class)
    public ResponseEntity<CustomErrorDTO> clientWithoutPermission(ClientWithoutPermissionException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        CustomErrorDTO error = new CustomErrorDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorDTO> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationErrorDTO error = new ValidationErrorDTO(Instant.now(), status.value(), "Invalid argument", request.getRequestURI());

        for(FieldError field : e.getBindingResult().getFieldErrors()) {
            error.addErrors(field.getField(), field.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(error);
    }

}
