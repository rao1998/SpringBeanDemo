package com.rx.spring.domain;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;

@Data
public class Person implements DisposableBean {
    private String name;
    private String address;
    private String tel;

    public Person(String name, String address, String tel) {
        System.out.println("Person--->>>有参构造方法");
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public Person() {
        System.out.println("Person--->>>无参构造方法");
    }

    private void raoInitMethod() {
        System.out.println("person--->>>InitMethod...");
    }

    private void raoDestroyMethod() {
        System.out.println("person--->>>DestroyMethod...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean接口】调用DisposableBean.destroy()");
    }
}
