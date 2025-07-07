package org.example.aopstudy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutAnnotationVariants {

    /**
     * для интерфейсов, помещенных этой аннотацией
     */
//    @Before("@target(org.example.aopstudy.annotation.LoggerAopAnnotation)")
//    public void beforeCallMethod0(JoinPoint js) {
//        System.out.println("callAnnotatedTarget " + js);
//    }

    /**
     * для классов, помеченных этой аннотацией
     */
    @Before("@within(org.example.aopstudy.annotation.LoggerAopAnnotation)")
    public void beforeCallMethod(JoinPoint js) {
        System.out.println("callAnnotatedTarget " + js);
    }

    /**
     * для методов, помеченных этой аннотацией
     */
    @Pointcut("@annotation(org.example.aopstudy.annotation.LoggerAopMethodAnnotation)")
    public void callAnnotatedMethod() {
    }

    @Before("callAnnotatedMethod()")
    public void beforeCallMethod2(JoinPoint js) {
        System.out.println("callAnnotatedMethod " + js);
    }

    /**
     * для параметров, помеченных этой аннотацией
     */
    @Pointcut("@args(org.example.aopstudy.annotation.LoggerAopFieldAnnotation)")
    public void callAnnotatedField() {
    }
//
//    @Before("callAnnotatedField()")
//    public void beforeCallMethod4(JoinPoint js) {
//        System.out.println("callAnnotatedField " + js);
//    }
}
