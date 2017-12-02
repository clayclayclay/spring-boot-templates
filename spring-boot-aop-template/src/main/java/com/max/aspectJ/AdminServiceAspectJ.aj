
package com.max.aspectJ;

public aspect AdminServiceAspectJ
{
    pointcut logBefore(): execution(* com.max.springaop.service.AdminServiceImpl.login(..));

    pointcut logAfter(): execution(* com.max.springaop.service.AdminServiceImpl.login(..));

    pointcut logAfterReturning(): execution(* com.max.springaop.service.AdminServiceImpl.getName(..));

    pointcut logAfterThrowing(): execution(* com.max.springaop.service.AdminServiceImpl.getAge(..));

    pointcut logAround(): execution(* com.max.springaop.service.AdminServiceImpl.play());

    before(): logBefore() {
        System.out.println("In AspectJ Before PointCut: logBefore() is running!");
    }

    after(): logAfter() {
        System.out.println("In AspectJ After PointCut: logAfter() is running!");
        System.out.println();
    }
}
