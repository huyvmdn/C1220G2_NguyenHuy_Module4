package com.case_study.furama.aspect;


import com.case_study.furama.Commons.ReadAndWrite;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Aspect
@Component
public class ServiceAspect {

    @After("execution(* com.case_study.furama.controller.ServiceController.save(..))")
    public void afterCallMethodSave(JoinPoint joinPoint) {
        System.err.println("After save run"+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        ReadAndWrite.writeFileString("service.csv","User Name: ["+ currentPrincipalName + "] After save run "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
    }

    @After("execution(* com.case_study.furama.controller.ServiceController.update(..))")
    public void updateObject(JoinPoint joinPoint) {
        System.err.println("After save run"+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        ReadAndWrite.writeFileString("service.csv","User Name: ["+ currentPrincipalName +"]After save run "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
    }

    //
    @After("execution(* com.case_study.furama.controller.ServiceController.delete(..))")
    public void delete(JoinPoint joinPoint) {
        System.err.println("After save run"+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        ReadAndWrite.writeFileString("service.csv","User Name: ["+ currentPrincipalName +"]After save run "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
    }

    @AfterThrowing(value = "execution(* com.case_study.furama.controller.ServiceController.*(..))",throwing = "e")
    public void beforeThrowEx(JoinPoint joinPoint, Exception e) {
        System.err.println("After Throwing"+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now());
        ReadAndWrite.writeFileString("service.csv","After Throwing "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
    }

}
