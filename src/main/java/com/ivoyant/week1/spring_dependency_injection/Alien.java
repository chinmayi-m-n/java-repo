package com.ivoyant.week1.spring_dependency_injection;

public class Alien {
    private int age;

    private Computer com;


    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public void setCom(Computer com){
        this.com=com;
    }

    public void code(){
        System.out.println("coding");
        //compile is the method inside Laptop class
        // to call that we need a object of Laptop class
        //if u create Laptop reference variable as instance variable and create property to set value for lap variable
        //at time of bean creation itself lap variable vl be assigned vth laptop object
        //we can use that reference to call compile() of laptop
        com.compile();
    }

}
