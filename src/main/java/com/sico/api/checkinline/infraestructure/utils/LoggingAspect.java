package com.sico.api.checkinline.infraestructure.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("within(com.sico.api.checkinline..*) && execution(* com.sico.api.checkinline..*.*(..))")
    public void publicMethodsInApp(){

    }

    @AfterReturning(pointcut = "(publicMethodsInApp() && @target(Logging)) || (publicMethodsInApp() && @annotation(Logging))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        try {
            logger.info("** AFTER RETURNING **");
            logger.info("Entering in method : {}", joinPoint.getSignature());
            logger.info("Class Name : {}", joinPoint.getSignature().getDeclaringTypeName());
            logger.info("Arguments : {}", Arrays.toString(joinPoint.getArgs()));
            logger.info("Target class : {}", joinPoint.getTarget().getClass().getName());
            logger.info("Method Return Value : {}", result);
        }
        catch (Exception var5){
            logger.error("** Error in after returning **", var5);
        }
    }

    @AfterThrowing(pointcut = "(publicMethodsInApp() && @target(Logging)) || (publicMethodsInApp() && @annotation(Logging))",
            throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception){
        try {
            logger.info("** AFTER THROWING **");
            String error = getStackTrace(exception);
            List<Object> arguments = new ArrayList<>(List.of(joinPoint.getArgs()));
            logger.error("An exception has been throw in {} {}", joinPoint.getSignature().getName(), "()");
            logger.error("Cause : {}", error);
        }
        catch (Exception var5){
            logger.error("** Error in after trowing **", var5);
        }
    }

    public LoggingAspect(){
    }

    private String getStackTrace( Throwable throwable) {
        StringWriter sw  = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
