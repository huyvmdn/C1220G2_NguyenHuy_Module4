package com.example.customer.logger;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @AfterThrowing(pointcut = "execution(public * com.example.customer.service.CustomerService.*(..))")
    public void error() {
        System.out.println("[CMS] ERROR!");
    }
}