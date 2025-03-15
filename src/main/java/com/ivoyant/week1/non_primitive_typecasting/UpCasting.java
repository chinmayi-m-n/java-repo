package com.ivoyant.week1.non_primitive_typecasting;

class Parent{
    public void show1(){
        System.out.println("in parent show");
    }
}
class Child extends Parent{
    public void show2(){
        System.out.println("in child show");
    }
}
class UpCasting{
    public static void main(String[] args) {
        //as child already has all properties of parent upcasting object from child type to parent type
        //is safe as it narrow downs accessibilty of methods to parent class methods
        Parent p=new Child();//implicitly upcasting will happens as it is safe
        p.show1();//valid : p can refer to Parent class methods
        //p.show2();     creates CTE bcz p can refer only Parent class methods
    }
}
