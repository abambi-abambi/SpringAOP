package org.example.aopstudy.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.example.aopstudy.service.MathUtil;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * For Native Spring Pointcut
 *
 * from org.springframework.aop.Pointcut
 * not from org.aspectj.lang.annotation.*
 */
@Configuration
public class NativeLoggerAspect {

    // The Pointcut
    public Pointcut someSpringframeworkPointcut() {
        // Pointcut is an interface
        // we need to implement methods
        return new Pointcut() {
            // ClassFilter is a Functional Interface
            // what kind of class we want to match
            @Override
            public ClassFilter getClassFilter() {
                return x -> x.isAssignableFrom(MathUtil.class);
            }

            // Which methods we want to match
            // MethodMatcher.TRUE = all methods
            @Override
            public MethodMatcher getMethodMatcher() {
                return MethodMatcher.TRUE;
            }
        };
    }

    // The Advice
    public MethodInterceptor mathUtilAroundAdvice() {
        return invocation -> {
            // Look at the Joinpoint before
            System.out.println("Native Spring AOP: before [" + invocation + "]");
            Object result = invocation.proceed();
            System.out.println("Native Spring AOP: result: " + result);
            return result;
        };
    }

    // Bind both: Pointcut & Advice
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        return new DefaultPointcutAdvisor(someSpringframeworkPointcut(), mathUtilAroundAdvice());
    }

    // The Weaver to connect the Advice with the JoinPoint
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}
