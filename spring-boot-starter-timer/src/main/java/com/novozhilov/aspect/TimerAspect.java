package com.novozhilov.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimerAspect {

    @Around("@annotation(com.novozhilov.annotation.Timer) || @within(com.novozhilov.annotation.Timer)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = signature.getName();

        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime) / 1000;

            log.info("{} - {} # {} seconds", className, methodName, duration);
        }
    }
}