package org.example.aopstudy.service;

import org.example.aopstudy.annotation.LoggerAopAnnotation;
import org.example.aopstudy.annotation.LoggerAopMethodAnnotation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MathUtil {

    public int getSum(int x, int y) {
        System.out.println("sum " + x + " + " + y + " = " + (x + y));
        if (x == 100) { // test for Exception
            throw new RuntimeException();
        }
        return x + y;
    }

    @LoggerAopMethodAnnotation
    public Long getResidual(int x, int y) {
        System.out.println("residual " + x + " - " + y + " = " + (x - y));
        return Long.valueOf(x - y);
    }
}
