package org.example.aopstudy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutVariants {

    /**
     * signature method match
     */
//    @Pointcut("execution(public int org.example.aopstudy.service.MathUtil.*(..))")
    @Pointcut("execution(public int org.example.aopstudy.service.MathUtil.*(int, ..))")
    public void executionPointCut() {
    }

    @Before("executionPointCut()")
    public void beforeCallMethod(JoinPoint js) {
        System.out.println("executionPointCut " + js);
    }

    /**
     * class for advice
     */
    @Pointcut("within(org.example.aopstudy.service.MathUtil)")
    public void withinPointCut() {
    }

    @Before("withinPointCut()")
    public void beforeCallMethod2(JoinPoint jp) {
        System.out.println("withinPointCut " + jp);
    }

    /**
     * target pointcut for class instance
     */
    @Pointcut("target(org.example.aopstudy.service.MathUtil)")
    public void targetPointCut() {
    }

    @Before("targetPointCut()")
    public void beforeCallMathod3(JoinPoint jp) {
        System.out.println("targetPointCut " + jp);
    }

    /**
     * bean pointcut
     * bean is named by class name (with first small letter)
     */
    @Pointcut("bean(mathUtil)")
    public void beanPointCut() {
    }

    @Before("beanPointCut()")
    public void beforeCallMethod4(JoinPoint jp) {
        System.out.println("beanPointCut " + jp);
    }

    /**
     * method args match pointcut
     */
    @Pointcut("args(int,int)")
    public void argsPointCut() {
    }

    @Before("argsPointCut()")
    public void baforeMethodCall5(JoinPoint js) {
        System.out.println("argsPointCut " + js);
    }
}
