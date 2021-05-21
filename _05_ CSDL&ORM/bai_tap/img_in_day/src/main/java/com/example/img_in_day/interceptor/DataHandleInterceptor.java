package com.example.img_in_day.interceptor;

import com.example.img_in_day.ripository.CommentRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataHandleInterceptor implements HandlerInterceptor {


    @Autowired
    CommentRipository ripository;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("starlist",ripository.countbyStar());
        return false;
    }
}
