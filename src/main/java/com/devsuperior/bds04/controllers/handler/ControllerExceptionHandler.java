package com.devsuperior.bds04.controllers.handler;

import com.devsuperior.bds04.controllers.exceptions.ClientWithoutPermissionException;
import com.devsuperior.bds04.controllers.exceptions.InvalidTokenException;
import com.devsuperior.bds04.dto.CustomErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
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

}
