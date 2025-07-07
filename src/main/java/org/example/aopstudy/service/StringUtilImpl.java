package org.example.aopstudy.service;

import org.example.aopstudy.annotation.LoggerAopAnnotation;
import org.springframework.stereotype.Component;

@Component
@LoggerAopAnnotation
public class StringUtilImpl implements StringUtil {

    public String getString(int x, int y) {
        System.out.println("Creating string from " + x + " and " + y);
        return "New string " + x + y;
    }
}
