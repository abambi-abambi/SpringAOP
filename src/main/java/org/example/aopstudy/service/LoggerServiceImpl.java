package org.example.aopstudy.service;

/**
 * даже не нужна аннотация @Component/@Service
 */
public class LoggerServiceImpl implements LoggerService{
    @Override
    public void sayHello() {
        System.out.println("Hello from LoggerServiceImpl");
    }
}
