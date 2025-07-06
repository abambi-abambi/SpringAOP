package org.example.aopstudy;

import org.example.aopstudy.service.MathUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static MathUtil mathUtil;

    public Application(MathUtil mathUtil) {
        this.mathUtil = mathUtil;
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class);

        mathUtil.getSum(1, 3);
        mathUtil.getSum(100, 1);
        mathUtil.getSum(101, 1);
    }
}
