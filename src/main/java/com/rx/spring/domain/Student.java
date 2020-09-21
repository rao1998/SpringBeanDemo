package com.rx.spring.domain;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;

@Data
public class Student implements DisposableBean {
    private String username;
    private String password;

    public Student(String username, String password) {
        System.out.println("Student--->>>有参构造方法");
        this.username = username;
        this.password = password;
    }
    public Student() {
        System.out.println("Student--->>>无参构造方法");
    }

    private void raoInitMethod() {
        System.out.println("student--->>>InitMethod...");
    }

    private void raoDestroyMethod() {
        System.out.println("student--->>>DestroyMethod...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean接口】调用DisposableBean.destroy()");
    }
}
