package com.trungdoan.demosecurity.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public ModelAndView showPageError(Exception e) {
        System.err.println(e.getMessage());
        return new ModelAndView("/authentication/error","mess",e.getMessage());
    }
}
