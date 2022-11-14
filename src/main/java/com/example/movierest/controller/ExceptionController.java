package com.example.movierest.controller;

import com.example.movierest.services.ExceptionService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@RequestMapping(value = "exception")
public class ExceptionController {
    private final ExceptionService exceptionService;

    public ExceptionController(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @RequestMapping(value = "/myException", method = RequestMethod.GET)
    public void method() {
        exceptionService.methodThrowsException();
    }
}
