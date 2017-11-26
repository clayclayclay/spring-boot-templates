package com.max.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component //this annotation is needed
public class AdminServiceAspect
{

    /*
     * 5 PointCut: Before After AfterReturning AfterThrowing Around
     */

    @Before("execution(* com.max.springaop.service.AdminServiceImpl.login(..))")
    public void logBefore(JoinPoint joinPoint)
    {
        System.out.println("Before PointCut: logBefore() is running!");
    }

    @After("execution(* com.max.springaop.service.AdminServiceImpl.login(..))")
    public void logAfter(JoinPoint joinPoint)
    {
        System.out.println("After PointCut: logAfter() is running!");
        System.out.println();
    }

    @AfterReturning(pointcut = "execution(* com.max.springaop.service.AdminServiceImpl.getName(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result)
    {
        System.out.println("AfterReturning PointCut: logAfterReturning() is running!");
        System.out.println("get result value: " + result + ", from target method: getName()");
        System.out.println();
    }

    @AfterThrowing(pointcut = "execution(* com.max.springaop.service.AdminServiceImpl.getAge(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error)
    {
        System.out.println("AfterThrowing PointCut: logAfterThrowing() is running!");
        System.out.println("the throwable exception is: " + error.getMessage());
        System.out.println();
    }

    @Around("execution(* com.max.springaop.service.AdminServiceImpl.play())")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("Around PointCut: logAround start");
        joinPoint.proceed();
        System.out.println("Around PointCut: logAround end");
    }

}
