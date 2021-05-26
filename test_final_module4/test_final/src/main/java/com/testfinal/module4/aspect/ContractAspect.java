//package com.testfinal.module4.aspect;
//
//
//import com.testfinal.module4.Commons.ReadAndWrite;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Aspect
//@Component
//public class ContractAspect {
//
//    @After("execution(* com.testfinal.module4.controller.ContractController.*(..))")
//    public void afterCallMethodSave(JoinPoint joinPoint) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//
//        System.err.println("User Name: "+ currentPrincipalName +"After save run  "+ joinPoint.getSignature().getName()+ " Time "+ LocalDateTime.now());
//        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run  "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
//    }
//
//    @After("execution(* com.testfinal.module4.controller.ContractDetailController.save(..))")
//    public void contractDetail(JoinPoint joinPoint) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        System.err.println("User Name: "+ currentPrincipalName +"After save run ContractDetailController "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());
//
//        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run ContractDetailController "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
//    }
//
//    @After("execution(* com.testfinal.module4.controller.ContractController.updateObject(..))")
//    public void updateObject(JoinPoint joinPoint) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        System.err.println("User Name: "+ currentPrincipalName +"After save run "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());
//        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
//    }
//
////    @After("execution(* com.testfinal.module4.controller.ContractDetailController.updateObject(..))")
////    public void updateObjectDetail(JoinPoint joinPoint) {
////
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        String currentPrincipalName = authentication.getName();
////        System.err.println("User Name: ["+ currentPrincipalName +"]After save run ContractDetailController "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());
////        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run ContractDetailController "+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now(),true);
////    }
////    //
////    @After("execution(* com.testfinal.module4.controller.ContractController.delete(..))")
////    public void delete(JoinPoint joinPoint) {
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        String currentPrincipalName = authentication.getName();
////        System.err.println("User Name: ["+ currentPrincipalName +"]After save run  "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());
////
////
////        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now(),true);
////    }
////
////    @After("execution(* com.testfinal.module4.controller.ContractDetailController.delete(..))")
////    public void deleteDetail(JoinPoint joinPoint) {
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        String currentPrincipalName = authentication.getName();
////        System.err.println("User Name: "+ currentPrincipalName +"After save run ContractDetailController "+ joinPoint.getSignature().getName()+ " Time " + LocalDateTime.now());
////        ReadAndWrite.writeFileString("contract.csv","User Name: ["+ currentPrincipalName +"]After save run ContractDetailController "+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now(),true);
////    }
//
//    @AfterThrowing(value = "execution(* com.testfinal.module4.controller.ContractController.*(..))",throwing = "e")
//    public void beforeThrowEx(JoinPoint joinPoint, Exception e) {
//        System.err.println("After Throwing"+ joinPoint.getSignature().getName()+ "Time" + LocalDateTime.now());
//        ReadAndWrite.writeFileString("contract.csv","After Throwing ["+ joinPoint.getSignature().getName()+ "]Time " + LocalDateTime.now(),true);
//    }
//
//
//}
