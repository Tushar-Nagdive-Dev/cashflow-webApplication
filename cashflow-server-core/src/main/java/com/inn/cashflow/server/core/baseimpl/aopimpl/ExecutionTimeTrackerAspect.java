package com.inn.cashflow.server.core.baseimpl.aopimpl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ExecutionTimeTrackerAspect {

    @Around("@annotation(com.cashflow.annotations.TrackExecutionTime)")
    public Object trackExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String threadName = Thread.currentThread().getName();
        try {
            Object proceed = joinPoint.proceed();
            return proceed;
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            log.info("Thread [{}] executed {}.{} in {} ms",
                    threadName,
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(),
                    duration);
        }
    }
}
