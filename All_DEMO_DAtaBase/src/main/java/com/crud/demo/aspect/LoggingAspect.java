package com.crud.demo.aspect;

import com.crud.demo.util.TrackExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect //
@Slf4j
public class LoggingAspect {


    // When - when will intercept , where - in which class or method , what - logging logic perform
//    @Before(value = "execution(* com.crud.demo.service.StudentService.fetchAllStudents(..))")
//    public void logBefore(){
//        log.info("before fetchAllStudents method call before ");
//    }
//
//    @AfterReturning(value = "execution(* com.crud.demo.service.StudentService.fetchAllStudents(..))" , returning = "result")
//    public void logAfterReturning(List<CreateStudentResponseDTO> result){
//        log.info("AfterReturning fetchAllStudents method call before ");
//    }

//    @AfterThrowing(value = "execution(* com.crud.demo.service.StudentService.createStudent(..))" , throwing ="throwable")
//    public void logAfterThrowing(Throwable throwable){
//        log.info("AfterThrowing fetchAllStudents method call before ");
//        log.info(throwable.getMessage());
//        log.info(throwable.getMessage());
//        log.info(throwable.getClass().getName());
//    }

//    @After(value = "execution(* com.crud.demo.service.StudentService.createStudent(..))")
//    public void logAfter() {
//        log.info("After createStudent method call.");
//    }

//    @Around(value = "execution(* com.crud.demo.service..*(..))")
//    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{
//        log.info("in Around  before target createStudent method call.");
//        joinPoint.proceed();
//        log.info("in Around  after target createStudent method execution");
//    }

    @Around(value = "@annotation(executionTime)")
    public Object logAround(ProceedingJoinPoint joinPoint , TrackExecutionTime executionTime ) throws Throwable{


        long startTime = System.nanoTime();
        log.info("Service class called : " + joinPoint.getClass().getName() + ":" + "execution start time : " + startTime);
        try {
            return joinPoint.proceed();
        }finally {
            long endTime  = System.nanoTime();
            long totalDuration = endTime - startTime ;
            log.info("Service class ended : " + joinPoint.getClass().getName() + ":" + "execution end time : " + startTime , ":" + totalDuration);

        }


    }


}
