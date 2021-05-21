package com.baitap.quan_ly_sach.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BookExceptionHandle {

    @ExceptionHandler(Exception.class)
    public ModelAndView showPageError() {
return new ModelAndView("/error");
    }
}
