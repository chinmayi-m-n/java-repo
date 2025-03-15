package com.ivoyant.week1.non_primitive_typecasting;

class P{
    public void show1(){
        System.out.println("in parent show");
    }
}
class C extends P{
    public void show2(){
        System.out.println("in child show");
    }
}
class DownCasting{
    public static void main(String[] args) {
        //casting object from Parent type to Child type => Downcasting
        //this is unsafe bcz object of parent class not necessarily has child class properties
        //parent class has properties of child class only if it holding reference of child class
        //if parent refernce is refering to child class object then typecasting parent refernece to child is allowed
        //if parent reference is holding parent class object then it doesnot hass child class properites hence in this case downcasting creates error
        // C child=(C) new P();  creates error
        P parent=new C();//parent has properties of C as it is refering to C object
        //hence parent can be downcasted to C
        C child=(C)parent;//valid
        child.show1();
        child.show2();




    }
}