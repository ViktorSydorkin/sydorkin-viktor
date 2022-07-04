package com.homework4.hw_4.entity.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class RuntimeExceptionHandler {
    @ExceptionHandler(RepositoryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RuntimeException serviceExceptionHandler(RepositoryException repositoryException){
        log.error("Repository exception occurred {} {}", repositoryException, repositoryException.getMessage());
        return new RuntimeException(repositoryException.getMessage());
    }
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RuntimeException serviceExceptionHandler(ServiceException serviceException){
        log.error("Service exception occurred {} {}", serviceException, serviceException.getMessage());
        return new RuntimeException(serviceException.getMessage());
    }
    @ExceptionHandler(ControllerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RuntimeException serviceExceptionHandler(ControllerException controllerException){
        log.error("Controller exception occurred {} {}", controllerException, controllerException.getMessage());
        return new RuntimeException(controllerException.getMessage());
    }
}
