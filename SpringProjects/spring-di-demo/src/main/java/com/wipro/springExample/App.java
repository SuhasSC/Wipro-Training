package com.wipro.springExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Delegate d = context.getBean(Delegate.class);

        d.notifyUser();

    }

}