package com.ivoyant.week2.annotations_based_configuration;

import com.ivoyant.week2.annotations_based_configuration.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    public Alien(){
        System.out.println("Alien object is created");
    }

    @Autowired
    @Qualifier("laptop")
    Computer com;//spring searches for bean of type Computer in IoC container and autowires it with com
    public void code(){
        System.out.println("coding.....");
        com.compile();
    }

}
