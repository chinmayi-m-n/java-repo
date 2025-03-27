package com.ivoyant.week3.SpringJDBC;

public class Student {
    private int rollno;
    private String name;
    private double marks;
    public void setRollno(int roll){
        this.rollno=roll;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setMarks(double marks){
        this.marks=marks;
    }
    public int getRollno(){
        return rollno;
    }
    public String getName(){
        return name;
    }
    public double getMarks(){
        return marks;
    }
    public String toString(){
        return "{rollNo "+rollno+" ,"+
                "name "+name+" ,"+
                "marks "+marks+" }";
    }
}
