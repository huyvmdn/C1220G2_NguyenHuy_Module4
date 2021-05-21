package com.baitap.quan_ly_sach.aspect;


import com.baitap.quan_ly_sach.Commons.ReadAndWrite;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class RentalCodeAspect {

    @After("execution(* com.baitap.quan_ly_sach.controller.BookController.save(..))")
    public void afterCallMethodSave(JoinPoint joinPoint) {

        System.err.println("After save run"+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now());
        ReadAndWrite.writeFileString("ghiLog.csv","After save run "+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now(),true);
    }

    @After("execution(* com.baitap.quan_ly_sach.controller.BookController.giveBack(..))")
    public void afterCallMethodGiveBack(JoinPoint joinPoint) {
        System.err.println("After GiveBack run"+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now());
        ReadAndWrite.writeFileString("ghiLog.csv","After GiveBack run "+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now(),true);
    }

    @After("execution(* com.baitap.quan_ly_sach.controller.BookController.*(..))")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.err.println("After run"+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now());
        ReadAndWrite.writeFileString("count.csv","After run "+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now(),true);
    }

    @AfterThrowing(value = "execution(* com.baitap.quan_ly_sach.controller.BookController.*(..))",throwing = "e")
    public void beforeThrowEx(JoinPoint joinPoint, Exception e) {
        System.err.println("After Throwing"+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now());
        ReadAndWrite.writeFileString("ghiLog.csv","After Throwing "+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now(),true);
    }

}
