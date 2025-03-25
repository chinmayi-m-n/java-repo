package com.ivoyant.week1.java_based_configuration;

import com.ivoyant.week1.java_based_configuration.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Alien alien=context.getBean(Alien.class);
        //
        alien.code();

    }
}
