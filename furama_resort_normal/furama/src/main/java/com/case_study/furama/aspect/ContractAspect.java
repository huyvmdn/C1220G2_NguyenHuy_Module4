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
public class ContractAspect {

    @After("execution(* com.case_study.furama.controller.ContractController.save(..))")
    public void afterCallMethodSave(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        System.err.println("User Name: "+ currentPrincipalName +"After save run  "+ joinPoint.getSignature().getName()+ " Time "+ LocalDateTime.now());
        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run  "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
    }

    @After("execution(* com.case_study.furama.controller.ContractDetailController.save(..))")
    public void contractDetail(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.err.println("User Name: "+ currentPrincipalName +"After save run ContractDetailController "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());

        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run ContractDetailController "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
    }

    @After("execution(* com.case_study.furama.controller.ContractController.updateObject(..))")
    public void updateObject(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.err.println("User Name: "+ currentPrincipalName +"After save run "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());
        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
    }

    @After("execution(* com.case_study.furama.controller.ContractDetailController.updateObject(..))")
    public void updateObjectDetail(JoinPoint joinPoint) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.err.println("User Name: ["+ currentPrincipalName +"]After save run ContractDetailController "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());
        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run ContractDetailController "+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now(),true);
    }
    //
    @After("execution(* com.case_study.furama.controller.ContractController.delete(..))")
    public void delete(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.err.println("User Name: ["+ currentPrincipalName +"]After save run  "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());


        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
    }

    @After("execution(* com.case_study.furama.controller.ContractDetailController.delete(..))")
    public void deleteDetail(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.err.println("User Name: "+ currentPrincipalName +"After save run ContractDetailController "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());
        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run ContractDetailController "+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now(),true);
    }

    @AfterThrowing(value = "execution(* com.case_study.furama.controller.ContractController.*(..))",throwing = "e")
    public void beforeThrowEx(JoinPoint joinPoint, Exception e) {
        System.err.println("After Throwing"+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now());
        ReadAndWrite.writeFileString("contract.csv","After Throwing ["+ joinPoint.getSignature().getName()+ "]Time " + LocalDateTime.now(),true);
    }


}
