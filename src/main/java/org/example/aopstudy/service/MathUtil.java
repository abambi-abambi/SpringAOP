package org.example.aopstudy.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MathUtil {

    public int getSum(int x, int y) {
        System.out.println("sum " + x + " + " + y + " = " + (x + y));
        if (x == 100) { // test
            throw new RuntimeException();
        }
        return x + y;
    }
}
