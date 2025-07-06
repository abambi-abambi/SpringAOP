package org.example.aopstudy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* org.example.aopstudy.service.MathUtil.*(..))")
    public void beforeCallMethod(JoinPoint jp) {
        System.out.println("Аспект @Before: вызван метод " + jp.getSignature().getName());
    }

    @Pointcut("execution(* org.example.aopstudy.service.MathUtil.*(..))")
    public void loggingServicemathUtil() {
    }

    @Before("loggingServicemathUtil()")
    public void beforeCallMethodVar2(JoinPoint jp) {
        System.out.println("Аспект @Before, вариант 2: вызван метод " + jp.getSignature().getName());
        System.out.println("Аргументы метода: " + Arrays.toString(jp.getArgs()));
        System.out.println("Прокси-объект: " + jp.getThis());
        System.out.println("Описание advice: " + jp);
    }

    @After("execution(* org.example.aopstudy.service.MathUtil.*(..))")
    public void afterCallMethodVar3(JoinPoint jp) {
        System.out.println("Аспект @After, вариант 3: после вызова метода " + jp.getSignature().getName());
    }

    @Around("execution(* org.example.aopstudy.service.MathUtil.*(..))")
    public Object aroundCallMethodVar3(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Аспект @Around, вокруг - 1 вызова метода " + jp.getSignature().getName());
        Object retVal = jp.proceed();
        System.out.println("Аспект @Around, вокруг - 2 вызова метода, который вернул " + retVal);
        return retVal;
    }

    @After("loggingServicemathUtil()")
    public void afterCallMethodVar2(JoinPoint jp) {
        System.out.println("Аспект @After, вариант 2: после вызова метода " + jp.getSignature().getName());
    }

    @AfterReturning(
            pointcut="execution(* org.example.aopstudy.service.MathUtil.*(..))",
            returning="retVal"
    )
    public void getAfterRetuning(JoinPoint jp, Object retVal) {
        System.out.println("Аспект @AfterReturning, возврат значения " + retVal + " из метода: " + jp.getSignature().getName());
    }

    @AfterThrowing(
            pointcut=("execution(* org.example.aopstudy.service.MathUtil.*(..))"),
            throwing = "ex"
    )
    public void getAfterException(JoinPoint jp, Exception ex) {
        System.out.println("Аспект @AfterThrowing, после эксепшена: " + jp + " " + ex.getMessage());
    }
}
