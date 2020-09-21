package com.rx.spring;

import com.rx.spring.domain.Person;
import com.rx.spring.domain.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("****开始启动****");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("****启动完毕****");

        Person person = applicationContext.getBean("person", Person.class);
        //Student student = applicationContext.getBean("student", Student.class);

        System.out.println("=============================================");
        System.out.println("person：" + person);
        //System.out.println("student：" + student);

        System.out.println("============现在开始关闭容器======================");
        applicationContext.registerShutdownHook();
    }
}
