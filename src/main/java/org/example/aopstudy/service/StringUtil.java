package org.example.aopstudy.service;

import org.example.aopstudy.annotation.LoggerAopFieldAnnotation;

public interface StringUtil {
    String getString(int x, @LoggerAopFieldAnnotation int y);
}
