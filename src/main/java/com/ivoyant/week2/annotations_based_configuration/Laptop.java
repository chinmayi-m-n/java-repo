package com.ivoyant.week2.annotations_based_configuration;

import com.ivoyant.week2.annotations_based_configuration.Computer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Laptop implements Computer {
    public Laptop(){
        System.out.println("Laptop object is created");
    }
    public void compile(){
        System.out.println("compiling in Laptop....");
    }
}
