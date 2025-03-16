package com.ivoyant.week1.spring_dependency_injection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        Alien obj1=(Alien)context.getBean("alien");
        System.out.println(obj1.getAge());
        // use alien object and call code which will indirectly call compile
        obj1.code();
    }
}
