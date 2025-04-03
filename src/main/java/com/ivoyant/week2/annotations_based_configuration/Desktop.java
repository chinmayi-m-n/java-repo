package com.ivoyant.week2.annotations_based_configuration;

import com.ivoyant.week2.annotations_based_configuration.Computer;
import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
    public Desktop(){
        System.out.println("desktop object is created");
    }
    public void compile(){
        System.out.println("compiling using Desktop....");
    }
}
