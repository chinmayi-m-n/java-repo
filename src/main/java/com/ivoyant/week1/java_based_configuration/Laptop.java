package com.ivoyant.week1.java_based_configuration;

public class Laptop implements Computer{
    public Laptop(){
        System.out.println("Laptop object is created");
    }
    public void compile(){
        System.out.println("compiling in Laptop....");
    }
}
