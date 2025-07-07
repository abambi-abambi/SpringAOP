package org.example.aopstudy;

import org.example.aopstudy.service.MathUtil;
import org.example.aopstudy.service.StringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {
    private static MathUtil mathUtil;
    private static StringUtil stringUtil;

    public Application(MathUtil mathUtil, StringUtil stringUtil) {
        this.mathUtil = mathUtil;
        this.stringUtil = stringUtil;
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class);


        mathUtil.getSum(1, 3);
//        mathUtil.getSum(100, 1);
        mathUtil.getSum(101, 1);
        mathUtil.getResidual(101, 1);

        stringUtil.getString(1, 2);
    }
}
