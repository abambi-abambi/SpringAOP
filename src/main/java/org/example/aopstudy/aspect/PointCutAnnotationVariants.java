package org.example.aopstudy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutAnnotationVariants {

//    @Pointcut("@target(org.example.aopstudy.annotation.LoggerAopAnnotation)")
//    public void callAnnotatedTarget() {
//    }
//
    @Before("@within(org.example.aopstudy.annotation.LoggerAopAnnotation)")
    public void beforeCallMethod(JoinPoint js) {
        System.out.println("callAnnotatedTarget " + js);
    }

    @Pointcut("@annotation(org.example.aopstudy.annotation.LoggerAopMethodAnnotation)")
    public void callAnnotatedMethod() {
    }

    @Before("callAnnotatedMethod()")
    public void beforeCallMethod2(JoinPoint js) {
        System.out.println("callAnnotatedMethod " + js);
    }
}
