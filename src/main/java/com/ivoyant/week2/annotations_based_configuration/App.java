package com.ivoyant.week2.annotations_based_configuration;

import com.ivoyant.week2.annotations_based_configuration.config.Appconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(Appconfig.class);
        Alien alien=context.getBean(Alien.class);
        alien.code();

    }
}
