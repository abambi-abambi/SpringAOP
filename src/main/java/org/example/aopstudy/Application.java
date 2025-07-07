package org.example.aopstudy;

import org.example.aopstudy.service.LoggerService;
import org.example.aopstudy.service.MathUtil;
import org.example.aopstudy.service.StringUtilImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static MathUtil mathUtil;
    private static StringUtilImpl stringUtilImpl;

    public Application(MathUtil mathUtil, StringUtilImpl stringUtilImpl) {
        this.mathUtil = mathUtil;
        this.stringUtilImpl = stringUtilImpl;
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class);


        mathUtil.getSum(1, 3);
//        mathUtil.getSum(100, 1);
        mathUtil.getSum(101, 1);
        mathUtil.getResidual(101, 1);

        stringUtilImpl.getString(1, 2);

        /**
         * каст к LoggerService,
         * ставшему "родителем" через Introduction
         */
        var logger = (LoggerService)mathUtil;
        logger.sayHello();
    }
}
