package org.example.aopstudy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.example.aopstudy.service.LoggerService;
import org.example.aopstudy.service.LoggerServiceImpl;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntroductionAspect {
    @DeclareParents(value = "org.example.aopstudy.service.MathUtil",
        defaultImpl = LoggerServiceImpl.class)
    public LoggerService loggerService;

    @Before("args(..) && this(loggerService)")
    public void introductionMethod(JoinPoint jp, LoggerService loggerService) {
        loggerService.sayHello();
    }
}
