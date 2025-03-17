package com.ivoyant.week1.java_based_configuration;

public class Alien {
    //whenever we call alien to code
    //he code and compile using either laptop or desktop depending on the type of object that we pass
    //we want spring to inject dependency for com
    Computer com;
    public Alien(Computer com){
        this.com=com;
    }
    public void setCom(Computer com){
        this.com=com;
    }

    public void code(){
        System.out.println("coding.....");
        com.compile();
    }

}
