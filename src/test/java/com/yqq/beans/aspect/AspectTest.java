package com.yqq.beans.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectTest {

    @Pointcut("execution(* *.test(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("beforeTest....");
    }


    @After("test()")
    public void afterTest() {
        System.out.println("afterTest...");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p) {

        System.out.println("before1...");

        Object object = null;
        try {
            object = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("after1...");
        return object;
    }


}
